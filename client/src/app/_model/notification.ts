import {Utilisateur} from './utilisateur.model';

export class Notification {
  id: number;
  utilisateur: Utilisateur;
  utilisateur1: Utilisateur;
  date: Date;
  lien: String;
  objet: String;
}
