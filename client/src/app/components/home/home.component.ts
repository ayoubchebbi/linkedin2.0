import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { first } from 'rxjs/operators';

import { AuthenticationService } from '../../_services';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  loginForm: FormGroup;
  RegisterForm: FormGroup;

  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {}


  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

    this.RegisterForm = this.formBuilder.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      titre: ['', Validators.required],
      pays: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });

    this.authenticationService.logout();
    this.returnUrl = '/dashboard';
  }

  get f() { return this.loginForm.controls; }
  get ff() { return this.RegisterForm.controls; }

  onSubmit() {
    this.submitted = true;

    this.loading = true;
    this.authenticationService.login(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.error = 'Invalid email or password.';
          this.loading = false;
        });
  }

  onRegister() {
    this.submitted = true;
    this.loading = true;
    this.authenticationService.register(this.ff.nom.value, this.ff.prenom.value, this.ff.email.value, this.ff.password.value, this.ff.titre.value, this.ff.pays.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.error = 'Invalid email or password.';
          this.loading = false;
        });

  }

}
