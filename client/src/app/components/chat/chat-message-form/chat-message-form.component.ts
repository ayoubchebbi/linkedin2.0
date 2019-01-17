import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from '../../../_model/utilisateur.model';
import {ChatMsjService} from '../../../_services/chat-messages/chat.service';

@Component({
  selector: 'app-chat-message-form',
  templateUrl: './chat-message-form.component.html',
  styleUrls: ['./chat-message-form.component.css']
})

export class ChatMessageFormComponent implements OnInit {
  messageToSend: string;
  @Input() friend: Utilisateur;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  inProgress = false;

  constructor(private chatService: ChatMsjService) {}

  ngOnInit() {}

  sendMessage() {
    this.inProgress = true;
    this.chatService.sendMessage(this.user.id, this.friend.id, this.messageToSend).subscribe(
      data => {
        // console.log(data);
      },
      errorCode => console.log(errorCode),
      () => {
        this.messageToSend = '';
        // this.clicked(this.friendsList[0]);
      }
    );
  }

}
