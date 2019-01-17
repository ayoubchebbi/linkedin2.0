import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Publication} from '../../_model/Publication';
import {catchError, map, tap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {environment} from '../../_config/conf';
import {Formation} from "../../_model/Formation";

@Injectable({
  providedIn: 'root'
})
export class PublicationService {

  constructor(private http: HttpClient) {}

  private publicationUrl = environment.URL + 'api/publication/';

  public getPublications() {
    return this.http.get<Publication[]>(this.publicationUrl);
  }

  public deletePublication(id) {
    return this.http.delete(this.publicationUrl + 'delete/' + id);
  }

  public getPublication(id) {
    return this.http.get<Publication>(this.publicationUrl + id);
  }

  public getPublicationUser(id) {
    return this.http.get<Publication[]>(this.publicationUrl + 'get/' + id);
  }

  public createPublication(publication) {
    return this.http.post<Publication>(this.publicationUrl + 'add/', publication);
  }
}
