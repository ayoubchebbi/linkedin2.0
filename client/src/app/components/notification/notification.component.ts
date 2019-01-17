import { Component, OnInit } from '@angular/core';
import {NotificationService} from '../../_services/notification/notification.service';
import {Router} from '@angular/router';
import {Notification} from '../../_model/notification';
import {Utilisateur} from '../../_model/utilisateur.model';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  notifications: Notification[];
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  constructor(private router: Router, private notificationService: NotificationService) { }

  ngOnInit() {
    this.notificationService.getNotificationsbyid(this.user.id)
      .subscribe( data => {
        this.notifications = data;
      });
  }

}
