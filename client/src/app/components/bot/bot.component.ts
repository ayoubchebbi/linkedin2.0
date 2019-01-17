import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ChatService, Message} from '../../_services/chatbot/chat.service';
import 'rxjs/add/operator/scan';

@Component({
  selector: 'app-bot',
  templateUrl: './bot.component.html',
  styleUrls: ['./bot.component.css']
})
export class BotComponent implements OnInit {

  messages: Observable<Message[]>;
  formValue: string;
  date = new Date();
  constructor(public chat: ChatService) { }

  ngOnInit() {
    // appends to array after each new message is added to feedSource
    this.messages = this.chat.conversation.asObservable()
      .scan((acc, val) => acc.concat(val) );
  }

  sendMessage() {
    this.chat.setmsg(this.formValue);
    this.chat.converse();
    this.formValue = '';
  }





}
