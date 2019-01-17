import {ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output, ViewRef} from '@angular/core';
import {RelationshipService} from '../../../_services/chat-messages/relationship.service';
import {Utilisateur} from '../../../_model/utilisateur.model';
import {Router} from '@angular/router';
import {ChatMsjService} from '../../../_services/chat-messages/chat.service';
import {Chat} from '../../../_model/chat.model';
import {Observable} from 'rxjs/Rx';

@Component({
  selector: 'app-chat-friends-list',
  templateUrl: './chat-friends-list.component.html',
  styleUrls: ['./chat-friends-list.component.css']
})

export class ChatFriendsListComponent implements OnInit {
  connection;
  @Input() user: Utilisateur;
  @Output()
  onFriendSelected: EventEmitter<Utilisateur> = new EventEmitter<any>();

  friendsList: Utilisateur[];
  friendSelected: Utilisateur;
  chatList: Chat[];

  constructor(private relationshipService: RelationshipService,
              private chatService: ChatMsjService,
              private router: Router,
              private ref: ChangeDetectorRef) {
  }

  clicked(friend: Utilisateur): void {
    this.friendSelected = friend;
    this.onFriendSelected.emit(friend);
  }

  getFriendsList() {
    this.relationshipService.getFriendsList(this.user['id'])
      .subscribe(
        data => {
          this.friendsList = data;
        },
        errorCode => console.log(errorCode),
        () => {
          console.log('friendSelected selected by default : ' + this.friendsList);
          this.clicked(this.friendsList[0]);
        }
      );
  }

  getLastMessagesByUserId() {
    this.chatService.getLastMessagesByUserId(this.user['id'])
      .subscribe(
        data => {
          this.chatList = data;
        },
        errorCode => console.log(errorCode),
        () => {
        }
      );
  }

  getLastMessageBetweenFriends(friend_id) {
    for (const chat of this.chatList) {
      if (chat.user_from_id === friend_id && chat.user_to_id === this.user.id) {
        return chat.message;
      }
      if (chat.user_to_id === friend_id && chat.user_from_id === this.user.id) {
        return 'You : ' + chat.message;
      }
    }
  }

  getLastMessageTime(friend_id) {
    for (const chat of this.chatList) {
      if (chat.user_from_id === friend_id && chat.user_to_id === this.user.id) {
        return chat.send_on;
      }
      if (chat.user_to_id === friend_id && chat.user_from_id === this.user.id) {
        return chat.send_on;
      }
    }
  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'))[1];
    if (this.user === null || typeof this.user === 'undefined') {
      this.router.navigate(['/']);
    } else {
      this.getFriendsList();
      this.getLastMessagesByUserId();

      this.connection = Observable.interval(1000).subscribe(x => {
        this.getLastMessagesByUserId();
      });

      /*if (!(this.ref as ViewRef).destroyed) {
        this.ref.detectChanges();
        this.connection.unsubscribe();
      }*/
    }
  }

  ngOnDestroy() {
    this.connection.unsubscribe();
  }

}
