import {Offre_UtilisateurId} from './Offre_UtilisateurId';
import {Offre_emploi} from './Offre_emploi';
import {Utilisateur} from './utilisateur.model';

export class Offre_Utilisateur {
  id: Offre_UtilisateurId;
  offreEmploi: Offre_emploi;
  utilisateur: Utilisateur;

}
