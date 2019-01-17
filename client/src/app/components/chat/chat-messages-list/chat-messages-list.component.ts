import {ChangeDetectorRef, Component, Input, OnInit, ViewRef} from '@angular/core';
import {Utilisateur} from '../../../_model/utilisateur.model';
import {ChatMsjService} from '../../../_services/chat-messages/chat.service';
import {Chat} from '../../../_model/chat.model';
import {Observable} from 'rxjs/Rx';

@Component({
  selector: 'app-chat-messages-list',
  templateUrl: './chat-messages-list.component.html',
  styleUrls: ['./chat-messages-list.component.css']
})
export class ChatMessagesListComponent implements OnInit {
  connection;
  @Input() friend: Utilisateur;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  messagesList: Chat[];

  constructor(private chatService: ChatMsjService, private ref: ChangeDetectorRef) {}

  ngOnInit() {
    this.getMessagesList();
    this.connection = Observable.interval(1000).subscribe(x => {
      this.getMessagesList();
    });
    /*if (!(this.ref as ViewRef).destroyed) {
      this.ref.detectChanges();
      this.connection.unsubscribe();
    }*/
  }

  getMessagesList() {
    this.chatService.getMessages(this.user.id, this.friend.id).subscribe(
      data => {
        this.messagesList = data;
      },
      errorCode => console.log(errorCode),
      () => {
      }
    );
  }

  ngOnDestroy() {
    this.connection.unsubscribe();
  }

}
