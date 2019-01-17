/*export class Connexion {
  id: number;
  idUtilisateur1: number;
  idUtilisateur2: number;
}*/
// ng g class model/Connexion

import {Utilisateur} from './utilisateur.model';

export class Connexion {
  id: number;
  utilisateurByIdUtilisateur1: Utilisateur;
  utilisateurByIdUtilisateur2: Utilisateur;
  ajout: number;
}
