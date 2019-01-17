import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../../_model/index';
import {environment} from '../../_config/conf';


@Injectable({ providedIn: 'root' })
export class UserService {

  constructor(private http: HttpClient) {
  }


  private UtilisateurUrl = environment.URL + 'api/utilisateur/';
  private httpOptions = {};


  getAll() {
    return this.http.get<User[]>(`/users`);
  }

/*public getUser() {
    return this.http.get<User[]>(this.UtilisateurUrl);
  }
*/

  public getUserById(id) {
    return this.http.get<User[]>(this.UtilisateurUrl + id);
  }

  public  updateUserDescription(UD) {
    return this.http.put<any>(this.UtilisateurUrl + 'update', UD);
  }

}
