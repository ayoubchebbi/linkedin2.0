import { BrowserModule } from '@angular/platform-browser';
import {NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NotificationComponent } from './components/notification/notification.component';
import { JobsComponent } from './components/jobs/jobs.component';
import { NetworkComponent } from './components/network/network.component';
import { HeaderComponent } from './components/common/header/header.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { ParametersComponent } from './components/parameters/parameters.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavuserComponent } from './components/common/navuser/navuser.component';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { BotComponent } from './components/bot/bot.component';

import {ChatFriendsListComponent} from './components/chat/chat-friends-list/chat-friends-list.component';
import {ChatMessageItemComponent} from './components/chat/chat-message-item/chat-message-item.component';
import {ChatMessagesListComponent} from './components/chat/chat-messages-list/chat-messages-list.component';
import {ChatMessageFormComponent} from './components/chat/chat-message-form/chat-message-form.component';
import {ChatComponent} from './components/chat';
import {RelationshipService} from './_services/chat-messages/relationship.service';
import {AuthenticationService, ChatService} from './_services';
import {ChatMsjService} from './_services/chat-messages/chat.service';

import {OrderModule} from 'ngx-order-pipe';
import { EmojifyModule } from 'angular-emojify';
import { FreshPipe } from './fresh.pipe';
import {CommentaireComponent} from './components/dashboard/commentaire/commentaire.component';
// import {InfiniteScrollModule} from 'ngx-infinite-scroll';
import { LikeComponent } from './components/dashboard/like/like.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    NotificationComponent,
    JobsComponent,
    NetworkComponent,
    HeaderComponent,
    FooterComponent,
    ParametersComponent,
    DashboardComponent,
    NavuserComponent,
    BotComponent,
    ChatFriendsListComponent,
    ChatMessagesListComponent,
    ChatMessageItemComponent,
    ChatMessageFormComponent,
    ChatComponent,
    FreshPipe,
    CommentaireComponent,
    LikeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    OrderModule,
    EmojifyModule,
    routing
  ],
  schemas: [ NO_ERRORS_SCHEMA],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    ChatService,
    AuthenticationService,
    RelationshipService,
    ChatMsjService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
