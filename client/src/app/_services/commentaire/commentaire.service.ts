import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Commentaire} from '../../_model/commentaire';
import {environment} from '../../_config/conf';
import {JAime} from '../../_model/j-aime';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService {


  constructor(private http: HttpClient) {}

  private commentaireUrl = environment.URL + 'api/commentaire/';

  public getCommentaires() {
    return this.http.get<Commentaire[]>(this.commentaireUrl);
  }

  public deleteCommentaire(id) {
    return this.http.delete(this.commentaireUrl + 'delete/' + id);
  }

  public getcommentaireByPublication(id) {
    return this.http.get<Commentaire[]>(this.commentaireUrl + 'commentairepub/' + id);
  }

  public  updatecommentaire(commentaire) {
    return this.http.put<any>(this.commentaireUrl + 'update/', commentaire);
  }

  public createCommentaire(commentaire) {
    return this.http.post<Commentaire>(this.commentaireUrl + 'add/', commentaire);
  }
}
