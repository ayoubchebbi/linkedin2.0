import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, FormGroup} from '@angular/forms';
import {JAimeService} from '../../../_services/j_aime/j-aime.service';
import {Utilisateur} from '../../../_model/utilisateur.model';
import {JAime} from '../../../_model/j-aime';
import {forEach} from '@angular/router/src/utils/collection';
import {CommentaireService} from '../../../_services/commentaire/commentaire.service';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent implements OnInit {

  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  jaime: JAime[];
  liked: boolean;
  nb: number;
  nbcomment: number;
  nbcpt = 0;
  @Input() childMessage: number;

  constructor(private router: Router, private http: HttpClient , private commentaireService: CommentaireService , private jaimeService: JAimeService, private formBuilder: FormBuilder) {
  }

  create_like() {

    const like = {'id': Math.floor(Math.random() * 1000) + 1, 'date': new Date(), 'utilisateur': JSON.parse(localStorage.getItem('currentUser'))[1], 'publication': this.childMessage};
    this.nbcpt = 0 ;
    this.jaimeService.getjaimeByPublication(this.childMessage).subscribe(data => {
      this.jaime = data;
      this.jaime.forEach(d => {
        if (d.publication === this.childMessage  && d.utilisateur.id === JSON.parse(localStorage.getItem('currentUser'))[1].id ) {

          this.nbcpt = this.nbcpt + 1 ;

        }

      });
      if (this.nbcpt === 0 ) {

        console.log(this.nbcpt);
        this.jaimeService.createjaime(like).subscribe(dd => {
          this.jaimeService.getjaimeByPublication(this.childMessage).subscribe(d1 => {this.nb = d1.length; });
        });
        this.liked = true;

      }  else {

        console.log(this.nbcpt);
        this.jaime.forEach(d => {
          if (d.publication ===  this.childMessage  && d.utilisateur.id === JSON.parse(localStorage.getItem('currentUser'))[1].id ) {

            this.jaimeService.deletejaime(d.id).subscribe(dd => {
              this.jaimeService.getjaimeByPublication(this.childMessage).subscribe(d1 => {this.nb = d1.length; });
            });

          }

        });
        this.liked = false;

      }

    });





  }




  ngOnInit() {
    this.commentaireService.getcommentaireByPublication(this.childMessage).subscribe(data => {
      this.nbcomment = data.length;
   });

    this.jaimeService.getjaimeByPublication(this.childMessage).subscribe(d1 => {
      this.nb = d1.length;
      this.liked = false;

      d1.forEach(d => {

        if (d.utilisateur.id === JSON.parse(localStorage.getItem('currentUser'))[1].id) {this.liked = true; }

      });


    });

  }

}
