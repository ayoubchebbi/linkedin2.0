import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Chat} from '../../../_model/chat.model';
import {Utilisateur} from '../../../_model/utilisateur.model';

@Component({
  selector: 'app-chat-message-item',
  templateUrl: './chat-message-item.component.html',
  styleUrls: ['./chat-message-item.component.css']
})
export class ChatMessageItemComponent implements OnInit {
  @ViewChild('container') container: ElementRef;
  @Input() message: Chat;
  @Input() friend: Utilisateur;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  result = 50;

  constructor() {
  }

  ngOnInit() {
  }

}
