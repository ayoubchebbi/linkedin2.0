import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';

import { ApiAiClient } from 'api-ai-javascript';

import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {Utilisateur} from '../../_model/utilisateur.model';

// Message class for displaying messages in the component
export class Message {
  constructor(public content: string, public sentBy: string) {}
}

@Injectable()
export class ChatService {

  readonly token = environment.dialogflow.angularBot;
  readonly client = new ApiAiClient({ accessToken: this.token });
  private msg: string;

  conversation = new BehaviorSubject<Message[]>([]);

  constructor() {}

  getmsg(): string {
    return this.msg;
  }

  setmsg(value: string) {
    this.msg = value;
  }

  // Sends and receives messages via DialogFlow
  converse() {
    const userMessage = new Message(this.msg, 'user');
    this.update(userMessage);

    return this.client.textRequest(this.msg)
      .then(res => {
        const speech = res.result.fulfillment.speech;
        const botMessage = new Message(speech, 'bot');
        this.update(botMessage);
      });
  }



  // Adds message to source
  update(msg: Message) {
    this.conversation.next([msg]);
  }

}
