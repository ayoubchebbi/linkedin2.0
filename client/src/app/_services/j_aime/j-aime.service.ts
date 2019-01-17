import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {JAime} from '../../_model/j-aime';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class JAimeService {

  constructor(private http: HttpClient) {}

  private jaimeUrl = environment.URL + 'api/jaime/';

  public getjaimes() {
    return this.http.get<JAime[]>(this.jaimeUrl);
  }

  public deletejaime(id) {
    return this.http.delete(this.jaimeUrl + 'delete/' + id);
  }

  public getjaime(id) {
    return this.http.get<JAime>(this.jaimeUrl + id);
  }

  public getjaimeByPublication(id) {
    return this.http.get<JAime[]>(this.jaimeUrl + 'jaimepub/' + id);
  }

  public createjaime(jaime) {
    return this.http.post<JAime>(this.jaimeUrl + 'add/', jaime);
  }
}
