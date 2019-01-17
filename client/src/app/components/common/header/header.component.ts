import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../../_services';
import {Utilisateur} from '../../../_model/utilisateur.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  constructor(private authenticationService: AuthenticationService) {  }

  logout() {
    this.authenticationService.logout();
  }

  ngOnInit() {
  }

}
