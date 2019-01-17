import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Observable} from 'rxjs/internal/Observable';
import {Utilisateur} from '../../_model/utilisateur.model';
import { environment } from '../../_config/conf';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {

  private userConnected: Utilisateur;
  private friendSelected: Utilisateur;

  constructor(private http: HttpClient) {}

  // Login

  login(email: string, password: string): Observable<boolean> {
    return this.http.post<any>(environment.URL + 'login', { 'email' : email, 'motDePasse': password })
      .pipe(
       map( res => {
        if (res && res.data[0]) {
          localStorage.setItem('currentUser', JSON.stringify(res.data));
          this.userConnected = JSON.parse(JSON.stringify(res.data[1]));
        }
        return res;
      }));
  }

  // Register

  register(nom: string, prenom: string, email: string, password: string, titre: string, pays: string): Observable<boolean> {
    const us = {
      nom: nom,
      prenom: prenom,
      email: email,
      motDePasse: password,
      titreProfil: titre,
      pays: pays,
      image_path: 'assets/images/users/default_pic_user.jpg',
      role: 0
    };
    return this.http.post<any>(environment.URL + 'register', us)
      .pipe(
        map( res => {
          if (res && res.data[0]) {
            localStorage.setItem('currentUser', JSON.stringify(res.data));
            this.userConnected = JSON.parse(JSON.stringify(res.data[1]));
          }
          return res;
        }));
  }

  // Logout

  logout() {
    localStorage.removeItem('currentUser');
  }

  getUserConnected() {
    return this.userConnected;
  }

  getFriendSelected(): Utilisateur {
    return this.friendSelected;
  }

  setFriendSelected(value: Utilisateur) {
    this.friendSelected = value;
  }

}
