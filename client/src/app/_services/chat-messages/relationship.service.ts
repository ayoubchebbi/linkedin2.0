import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Injectable} from '@angular/core';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Utilisateur} from '../../_model/utilisateur.model';
import {environment} from '../../_config/conf';

@Injectable()
export class RelationshipService {
  private relationshipUrl = environment.URLCHAT + 'relationship/';

  constructor(private http: HttpClient) {
  }

  getFriendsList(id: number): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.relationshipUrl + 'friendsList/' + id);
  }
}
