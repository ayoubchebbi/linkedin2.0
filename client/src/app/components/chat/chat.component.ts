import {Component, OnInit, OnDestroy, ElementRef, ViewChild} from '@angular/core';
import {Utilisateur} from '../../_model/utilisateur.model';
import {AuthenticationService} from '../../_services';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit, OnDestroy {
  user: Utilisateur = this.userService.getUserConnected();
  friend: Utilisateur;

  constructor(private userService: AuthenticationService) {}

  friendWasSelected(friend: Utilisateur) {
    console.log(friend);
    this.friend = friend;
    this.userService.setFriendSelected(friend);
  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }
}
