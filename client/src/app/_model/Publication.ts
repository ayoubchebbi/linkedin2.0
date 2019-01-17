import {Utilisateur} from './utilisateur.model';

export class Publication {
  id: number;
  date: Date;
  utilisateur: Utilisateur;
  contenu: string;
  fichier: string;
}
// ng g class _model/Publication

