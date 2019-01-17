import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Langue } from '../../_model/Langue';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class LangueService {

  constructor(private http: HttpClient) { }
  private LangueUrl = environment.URL + 'api/langue/';
  private httpOptions = {};


  public createLangue(langue) {
    return this.http.post<any>(this. LangueUrl + 'add', langue);
  }

  public  updateLangue(langue) {
    return this.http.put<any>(this.LangueUrl + 'update',langue);
  }


  public getLangue() {
    return this.http.get<Langue[]>(this.LangueUrl );
  }

  public deleteLangue(id) {
    return this.http.delete(this.LangueUrl  + 'delete' + id);
  }

  public getLangueUser(id) {
    return this.http.get<Langue[]>(this.LangueUrl + 'get/' + id);
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
