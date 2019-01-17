import { Injectable } from '@angular/core';
import {Connexion} from '../../_model/Connexion';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {

  constructor(private http: HttpClient) {}

  private connexionUrl = environment.URL + 'api/connexion/';

  private httpOptions = {
  };

  public updateConnexion(connexion) {
    console.log('connexion.service.ts');
    return this.http.put<any>(this.connexionUrl + 'update' , connexion);
  }

  public deleteConnexion(id) {
    return this.http.delete(this.connexionUrl + 'delete/' + id);
  }

  public createConnexion(connexion) {
    return this.http.post<any>(this.connexionUrl + 'add' , connexion);


  }
  public getConnexionByIds(id1, id2) {
    return this.http.get<any>(this.connexionUrl + 'GetByIds/' + id1 + '/' + id2).pipe(map(res => {
      return res;
    }));
  }


  public getConnexionsById(id) {
    return this.http.get<Connexion>(this.connexionUrl + 'get/' + id).pipe(map(res => {
      return res;
    }));
  }


  public getConnexions(id) {
    return this.http.get<any>(this.connexionUrl + 'List_amis/' + id).pipe(map(res => {
      return res;
    }));
  }
  public getConnexions2(id) {
    return this.http.get<any>(this.connexionUrl + 'List_amis2/' + id).pipe(map(res => {
      return res;
    }));
  }

  public getRecommendations(id) {
    return this.http.get<any>(this.connexionUrl + 'recommended_friends/' + id).pipe(map(res => {
      console.log(res);
      return res;
    }));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    };
  }
}
