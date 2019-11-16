import { Component, OnInit, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Path } from 'src/app/infrastructure/constans/Path';
import { User } from 'src/app/domain/User';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';
import { LoginService } from 'src/app/services/authentication/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Input() @Output()
  public authentication: boolean;
  public notuser: boolean;
  public notuserexist: boolean;
  public notUserEmpty: string;
  public notUserExist: string;
  public logo: string;
  public user: User;
  public loading: string;
  public load: boolean;

  constructor(private router: Router, private service: LoginService) {
    this.logo = Path.logo;
    this.notuser = false;
    this.load = false;
    this.notUserEmpty = Mensaje.notUserEmpty;
    this.notUserExist = Mensaje.notUserExist;
    this.loading = Path.loading;
    this.user = new User();
  }

  ngOnInit() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
    if (this.authentication) {
      this.router.navigate(['main']);
    }
  }

  getAuth(auth: string) {
    if (auth === 'true') {
      this.authentication = true;
    } else {
      this.authentication = false;
    }
  }

  login() {
    if (this.user.nickname === undefined || this.user.nickname.trim() === '' || this.user.nickname.length === 0) {
      this.notUser(1);
    } else if (this.user.nickname.length >= 0) {
      this.load = true;
      this.authenticationByNickname(this.user.nickname);
    }
  }

  authenticationByNickname(nickname: string) {
    this.service.authenticationLogin(nickname).subscribe(data => {
      this.load = false;
      if (data) {
        console.log('authentication successful');
        this.setAuthentication();
      } else {
        this.notUser(2);
      }
    });
  }

  setAuthentication() {
    this.authentication = true;
    localStorage.setItem('authentication', 'true');
    this.router.navigate(['main']);
  }

  notUser(id: number) {
    if (id === 1) {
      this.notuserexist = false;
      this.notuser = true;
    } else if (id === 2) {
      this.notuser = false;
      this.notuserexist = true;
    }
  }

  closeSpan() {
    this.user.nickname = '';
    this.user.password = '';
    this.notuserexist = false;
    this.notuser = false;
  }
}
