import { Component, OnInit } from '@angular/core';
import {Connexion} from '../../_model/Connexion';
import {Router} from '@angular/router';
import {ConnexionService} from '../../_services/connexion/connexion.service';
import {UserService} from '../../_services';
import {Utilisateur} from '../../_model/utilisateur.model';

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})
export class NetworkComponent implements OnInit {
  cnx : Connexion;
  connexions: Connexion[];
  connexions2: Connexion[];
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  constructor(private router: Router, private connexionService: ConnexionService, private utilisateurservice: UserService) { }

  delete_connexion(con) {

   /* const id1 = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const connexion = { 'utilisateurByIdUtilisateur1': {'id': id}  , 'utilisateurByIdUtilisateur2': {'id': id1}};
    this.connexionService.deleteConnexion(connexion).subscribe();*/
    // window.location.reload();

      let i =null;
      let j =null;

      i = this.connexions.findIndex( c => c.id  === con.id && c.utilisateurByIdUtilisateur1.id === con.utilisateurByIdUtilisateur1.id
        && c.utilisateurByIdUtilisateur2.id === con.utilisateurByIdUtilisateur2.id);
      console.log("i=",i);
      if(i!=-1)
        this.connexions.splice(i, 1);

      j = this.connexions2.findIndex(c => c.id  === con.id && c.utilisateurByIdUtilisateur1.id === con.utilisateurByIdUtilisateur1.id
      && c.utilisateurByIdUtilisateur2.id === con.utilisateurByIdUtilisateur2.id);
      console.log("j=",j);
      if(j!=-1)
        this.connexions2.splice(j, 1);

    this.connexionService.deleteConnexion(con.id).subscribe();
    //window.location.reload()

  }
  ngOnInit() {
    this.connexionService.getConnexions(this.user.id)
      .subscribe( data => {
        console.log();
        this.connexions = data;
      });
    this.connexionService.getConnexions2(this.user.id)
      .subscribe( data => {
        console.log();
        this.connexions2 = data;
      });
  }

}
