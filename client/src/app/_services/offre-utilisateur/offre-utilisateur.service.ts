import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Offre_emploi} from '../../_model/Offre_emploi';
import {catchError, map, tap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class OffreUtilisateurService {

  constructor(private http: HttpClient) {}

  private OffreUtilisateurUrl = environment.URL + 'api/offreUtilisateur/';

  private httpOptions = {
  };



  public createOffreUtilisateur(offre_utilisateur) {
    return this.http.post<any>(this.OffreUtilisateurUrl + 'add', offre_utilisateur);
  }

  public deleteOffreUtilisateur(id) {
    return this.http.delete(this.OffreUtilisateurUrl + 'delete/' + id);
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
