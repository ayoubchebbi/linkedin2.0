import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Formation} from '../../_model/Formation';
import {environment} from '../../_config/conf';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class FormationService {


  constructor(private http: HttpClient) {}

  private FormationUrl = environment.URL + 'api/formation/';

  private httpOptions = {};


  public createFormation(formation) {
    return this.http.post<any>(this. FormationUrl + 'add', formation);
 }

  public getFormationUser(id) {
    return this.http.get<Formation[]>(this.FormationUrl + 'get/' + id);
  }


  public  updateFormation(formation) {
    return this.http.put<any>(this.FormationUrl + 'update',formation);
  }

  /*public getFormation() {
    return this.http.get<Formation[]>(this.FormationUrl);
  }*/

  public deleteFormation(id) {
    return this.http.delete(this.FormationUrl + 'delete' + id);
  }

  public getFormation(id) {
    return this.http.get<any>(this.FormationUrl + id).pipe(map(res => {
      console.log(res);
      return res;
    }));
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
