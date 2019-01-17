import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Competence} from '../../_model/Competence';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {

  constructor(private http: HttpClient) { }

  private CompetenceUrl = environment.URL + 'api/competence/';

  private httpOptions = {};


  public createCompetence(competence) {
    return this.http.post<any>(this. CompetenceUrl + 'add', competence);
  }
  public  updateCompetence(competence) {
    return this.http.put<any>(this.CompetenceUrl + 'update',competence);
  }

  public getCompetence() {
    return this.http.get<Competence[]>(this.CompetenceUrl);
  }

  public deleteCompetence(id) {
    return this.http.delete(this.CompetenceUrl + 'delete' + id);
  }

  public getCompetenceUser(id) {
    return this.http.get<Competence[]>(this.CompetenceUrl + 'get/' + id);
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    };
  }
}
