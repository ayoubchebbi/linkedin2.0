import {Publication} from './Publication';
import {Utilisateur} from './utilisateur.model';

export class Commentaire {

  id: number;
  publication: number;
  utilisateur: Utilisateur;
  contenu: String;
  date: Date;

}
