import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {PublicationService} from '../../_services/publication/publication.service';
import {Offre_emploi} from '../../_model/Offre_emploi';
import {OffreEmploiService} from '../../_services/offre-emploi/offre-emploi.service';
import {OffreUtilisateurService} from '../../_services/offre-utilisateur/offre-utilisateur.service';
import {Utilisateur} from '../../_model/utilisateur.model';
import {ChatService} from '../../_services';
import { Observable } from 'rxjs/Rx';
import {NotificationService} from '../../_services/notification/notification.service';


@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  offer_clicked = null;
  offre_emploi: Offre_emploi[];
  postForm: FormGroup;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  show = false;
  clicked = false;
  filter: string = null;
  constructor(private router: Router, private offreEmploiService: OffreEmploiService, private notificationService: NotificationService, private offreUtilisateurService: OffreUtilisateurService, private formBuilder: FormBuilder
  , private ChatService: ChatService) {
  }

  delete_Offre_emploi(offre) {
    console.log(offre.id);
    this.offreEmploiService.deleteOffreEmploi(offre.id).subscribe();
    const i = this.offre_emploi.indexOf(offre);
    this.offre_emploi.splice(i, 1);
  }


  update_Offre_emploi(offre) {
    console.log(offre.id);
    const offre_emploi = {	'id':offre.id ,'nomOffre': offre.nomOffre, 'descOffre': this.f.descOffre2.value ,'price': offre.price,'place': offre.place,'date': offre.date, 'utilisateur': offre.utilisateur,'hashtag1':offre.hashtag1.toUpperCase(),'hashtag2':offre.hashtag2.toUpperCase(),'hashtag3':offre.hashtag3.toUpperCase()};
    this.offreEmploiService.updateOffreEmploi(offre_emploi).subscribe();
    const i = this.offre_emploi.indexOf(offre);
    this.offre_emploi.splice(i,1);
    this.offre_emploi.splice(i,0,offre_emploi);

  }

  create_Offre_emploi() {
    const offre_emploi = { 	'nomOffre': this.f.nomOffre.value, 'descOffre': this.f.descOffre.value, 'price': this.f.price.value, 'place': this.f.place.value, 'date': new Date(), 'utilisateur': JSON.parse(localStorage.getItem('currentUser'))[1], 'hashtag1': ((this.f.hashtag1.value).toString()).toUpperCase(), 'hashtag2': ((this.f.hashtag2.value).toString()).toUpperCase(), 'hashtag3': ((this.f.hashtag3.value).toString()).toUpperCase()};
    console.log(offre_emploi);
    this.offreEmploiService.createOffreEmploi(offre_emploi).subscribe();
    this.offre_emploi.push(offre_emploi);
    this.postForm.reset();

    setTimeout(() => this.offreEmploiService.getOffreEmploi(this.user.id)
      .subscribe( data => {
        this.offre_emploi =data;
      }), 500)

  }

  offer_cli(offre){
    this.offer_clicked=offre;
    return null;
  }


  create_Offre_utilisateur(offre) {

    const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const date = new Date();
    const offre_utilisateur = { 	'id': {'idOffre': offre.id, 'idUser': id, 'date': date}, 'utilisateur': JSON.parse(localStorage.getItem('currentUser'))[1] , 'offreEmploi': offre};
    this.offreUtilisateurService.createOffreUtilisateur(offre_utilisateur).subscribe();
    const i = this.offre_emploi.indexOf(offre);
    this.offre_emploi.splice(i, 1);
    const notification = { 'utilisateur' : JSON.parse(localStorage.getItem('currentUser'))[1], 'utilisateur1' : offre.utilisateur , 'date': date , 'lien' : "#" , 'objet' : offre.nomOffre};
    this.notificationService.createNotification(notification).subscribe();
  }


  get f() { return this.postForm.controls; }

  ngOnInit() {

    this.postForm = this.formBuilder.group({
      nomOffre: ['', Validators.required],
      descOffre: ['', Validators.required],
      place: ['', Validators.required],
      price: ['', Validators.required],
      hashtag1 : ['', Validators.required],
      hashtag2 : ['', Validators.required],
      hashtag3 : ['', Validators.required],
      descOffre2: ['', Validators.required]
    });


    Observable.interval(1000).subscribe(x => {
      this.filter = this.ChatService.getmsg();
    });

    this.offreEmploiService.getOffreEmploi(this.user.id)
      .subscribe( data => {
        this.offre_emploi = data;
      });
  }
}
