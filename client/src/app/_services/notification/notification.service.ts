import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Notification} from '../../_model/notification';
import {environment} from '../../_config/conf';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) {}

  private notificationUrl = environment.URL + 'api/notification/';

  public getNotifications() {
    return this.http.get<Notification[]>(this.notificationUrl);
  }

  public getNotificationsbyid(id) {
    return this.http.get<Notification[]>(this.notificationUrl + 'user/' + id);
  }

  public deleteNotification(notification) {
    return this.http.delete(this.notificationUrl + '/' + notification.id);
  }

  public createNotification(notification) {
    return this.http.post<any>(this.notificationUrl + 'add', notification);
  }
}
