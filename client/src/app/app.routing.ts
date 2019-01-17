import { RouterModule, Route} from '@angular/router';

import { AuthGuard } from './_guards';


import {HomeComponent} from './components/home/home.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {NetworkComponent} from './components/network/network.component';
import {JobsComponent} from './components/jobs/jobs.component';
import {ChatComponent} from './components/chat';
import {ProfileComponent} from './components/profile/profile.component';
import {NotificationComponent} from './components/notification/notification.component';
import {ParametersComponent} from './components/parameters/parameters.component';


export const routes: Route[] = [
  {path : '', component : HomeComponent },
  {path : 'dashboard', component : DashboardComponent, canActivate: [AuthGuard] },
  {path : 'network', component : NetworkComponent, canActivate: [AuthGuard] },
  {path : 'jobs', component : JobsComponent, canActivate: [AuthGuard] },
  {path : 'messages', component : ChatComponent, canActivate: [AuthGuard] },
  {path : 'notification', component : NotificationComponent, canActivate: [AuthGuard] },
  {path : 'profile', component : ProfileComponent , canActivate: [AuthGuard]},
  {path : 'settings', component : ParametersComponent, canActivate: [AuthGuard] },
];

export const routing = RouterModule.forRoot(routes);
