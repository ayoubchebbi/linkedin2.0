import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Offre_emploi} from '../../_model/Offre_emploi';
import {catchError, map, tap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class OffreEmploiService {

  constructor(private http: HttpClient) {}

  private OffreEmploiUrl = environment.URL + 'api/offreEmploi/';

  private httpOptions = {
  };

  public getOffreEmploi(id) {
    return this.http.get<any>(this.OffreEmploiUrl + id).pipe(map(res => {
      console.log(res);
      return res;
    }));
  }

  public getLastId() {
    return this.http.get<any>(this.OffreEmploiUrl + 'getlastid').pipe(map(res => {
      console.log(res);
      return res;
    }));
  }

  public deleteOffreEmploi(id) {
    return this.http.delete(this.OffreEmploiUrl + 'delete/' + id);
  }

  public updateOffreEmploi(offre) {
    return this.http.put<any>(this.OffreEmploiUrl + 'update', offre);
  }


  public createOffreEmploi(offre) {
    return this.http.post<any>(this.OffreEmploiUrl + 'add', offre);
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
