import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Chat} from '../../_model/chat.model';
import { environment } from '../../_config/conf';

@Injectable()
export class ChatMsjService {
  private chatUrl = environment.URLCHAT + 'chat/';

  constructor(private http: HttpClient) {}

  sendMessage(user_from_id, user_to_id, message): Observable<Chat> {

    const params = {
      user_from_id: user_from_id,
      user_to_id: user_to_id,
      message: message
    };

    return this.http.post<Chat>(this.chatUrl, JSON.stringify(params), {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    }).map(res => {
      return res;
    })
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getMessages(me, friend): Observable<Chat[]> {
    const data = this.http.get<Chat[]>(this.chatUrl + me + '/' + friend);
    return data;
  }

  getLastMessagesByUserId(me): Observable<Chat[]> {
    return this.http.get<Chat[]>(this.chatUrl + me);
  }
}



