export class Utilisateur {
  constructor(public id: number,
              public nom: string,
              public prenom: string,
              public email: string,
              public password: string,
              public titre_profil: string,
              public role: number,
              public image_path: string,
              public description: string) {
  }
}
