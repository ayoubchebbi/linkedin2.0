import {Component, Input, OnInit} from '@angular/core';
import {CommentaireService} from '../../../_services/commentaire/commentaire.service';
import {Router} from '@angular/router';
import {Commentaire} from '../../../_model/commentaire';
import {Utilisateur} from '../../../_model/utilisateur.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PublicationService} from '../../../_services';
import {Publication} from '../../../_model/Publication';
import {HttpClient} from '@angular/common/http';
import {NotificationService} from '../../../_services/notification/notification.service';

@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.css']
})
export class CommentaireComponent implements OnInit {

  @Input() childMessage: number;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  commentaires: Commentaire[];
  postForm: FormGroup;
  postForm2: FormGroup;
  show = false;
  idupdate: Number;
  constructor(private router: Router, private notficationService: NotificationService, private publicationService: PublicationService, private http: HttpClient ,  private commentairesService: CommentaireService, private formBuilder: FormBuilder) {
  }

  update_commentaire(commentaire) {





    commentaire.contenu =  this.f2.contenu.value;

    if (commentaire.contenu !== '') {
      this.commentairesService.deleteCommentaire(commentaire.id).subscribe(data => {

        this.commentairesService.createCommentaire(commentaire).subscribe();

      });
    }
    this.show = false;
    this.idupdate = 0;


  }

  toggle(commentaire) {
    this.show = false;
    this.show = true;
    this.idupdate = commentaire.id;
  }


  delete_commentaire(commentaire) {
    this.commentairesService.deleteCommentaire(commentaire.id)
      .subscribe( data => {
        this.commentaires = this.commentaires.filter(u => u !== commentaire);
      });
  }




  create_commentaire() {


    const commentaire = {'id': Math.floor(Math.random() * 500) + 1, 'contenu': this.f.contenu.value, 'date': new Date(), 'utilisateur': JSON.parse(localStorage.getItem('currentUser'))[1], 'publication': this.childMessage};


    if (commentaire.contenu !== '') {
      this.commentairesService.createCommentaire(commentaire).subscribe(data => {
        this.commentaires.push(commentaire);
        this.postForm.reset();
      });
    }
  }

  get f() { return this.postForm.controls; }
  get f2() { return this.postForm2.controls; }



  ngOnInit() {

    this.postForm = this.formBuilder.group({
      contenu: ['', Validators.required]
    });
    this.postForm2 = this.formBuilder.group({
      contenu: ['', Validators.required]
    });

    this.commentairesService.getCommentaires()
      .subscribe( data => {
        this.commentaires = data;
      });


  }
}
