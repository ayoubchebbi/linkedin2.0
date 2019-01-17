import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Formation} from '../../_model/Formation';
import {Observable, of} from 'rxjs';
import {Experience} from '../../_model/Experience';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor(private http: HttpClient) { }
  private ExperienceUrl = environment.URL + 'api/experience/';
  private httpOptions = {};



  public createExperience(experience) {
    return this.http.post<any>(this. ExperienceUrl + 'add', experience);
  }

  public  updateExperience(experience) {
    return this.http.put<any>(this.ExperienceUrl + 'update',experience);
  }

  public getExperienceUser(id) {
    return this.http.get<Experience[]>(this.ExperienceUrl + 'get/' + id);
  }


  public getExperience() {
    return this.http.get<Experience[]>(this.ExperienceUrl);
  }

  public deleteExperience(id) {
    return this.http.delete(this.ExperienceUrl + 'delete' + id);
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
