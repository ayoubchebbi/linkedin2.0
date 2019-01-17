import { Component, OnInit } from '@angular/core';
import {Publication} from '../../_model/Publication';
import {Router} from '@angular/router';
import {PublicationService} from '../../_services/publication/publication.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Utilisateur} from '../../_model/utilisateur.model';
import {ConnexionService} from '../../_services/connexion/connexion.service';
import {Connexion} from '../../_model/Connexion';
import {OffreEmploiService} from "../../_services/offre-emploi/offre-emploi.service";
import {Offre_emploi} from "../../_model/Offre_emploi";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router, private publicationService: PublicationService, private formBuilder: FormBuilder, private connexionService: ConnexionService,private offreEmploiService: OffreEmploiService) {

  }

  get f() { return this.postForm.controls; }
  get f2() { return this.postForm2.controls; }
  offre_emploi: Offre_emploi[];
  publications: Publication[];
  postForm: FormGroup;
  postForm2: FormGroup;
  show = false;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  connexions: Connexion[];
  notFriends: Utilisateur[];
  notFriends2: Utilisateur[];
  idupdate: Number;


  onScroll() {
    console.log('scrolled!!');
  }
  create_postulation() {
    const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const publication = {'id': Math.floor(Math.random() * 100) + 1, 'contenu': this.f.contenu.value, 'date': new Date(), 'fichier': 'fichier', 'utilisateur': JSON.parse(localStorage.getItem('currentUser'))[1]};
    if (publication.contenu !== '') {
      this.publicationService.createPublication(publication).subscribe(data => {
       this.publications.push(publication);
        this.postForm.reset();
      });
    }
  }

  toggle(commentaire) {
    this.show = false;
    this.show = true;
    this.idupdate = commentaire.id;
  }

  update_postulation(publication) {

    publication.contenu =  this.f2.contenu.value;

    if (publication.contenu !== '') {
      this.publicationService.deletePublication(publication.id).subscribe(data => {

        this.publicationService.createPublication(publication).subscribe();

      });
    }
    this.show = false;


  }

  delete_postulation(publication: Publication) {
    this.publicationService.deletePublication(publication.id)
      .subscribe( data => {
        this.publications = this.publications.filter(u => u !== publication);
      });
  }




  ngOnInit() {
    this.postForm = this.formBuilder.group({
      contenu: ['', Validators.required]
    });
    this.postForm2 = this.formBuilder.group({
      contenu: ['', Validators.required]
    });
    this.publicationService.getPublications()
      .subscribe( data => {
        this.publications = data;
        this.publications.reverse();

      });
    this.connexionService.getRecommendations(this.user.id)
      .subscribe( data => {
        console.log();
        this.notFriends = data;
      });

    this.offreEmploiService.getOffreEmploi(this.user.id)
      .subscribe( data => {
        this.offre_emploi = data;
      });

  }
}
