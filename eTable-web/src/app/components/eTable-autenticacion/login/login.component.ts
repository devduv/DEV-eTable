import { Component, OnInit, Input, Output, DoCheck} from '@angular/core';
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
export class LoginComponent implements OnInit, DoCheck {

  public authentication: boolean;
  public registration: boolean;
  public notuser: boolean;
  public notuserexist: boolean;
  public notpass: boolean;
  public notUserEmpty: string;
  public notPassEmpty: string;
  public notUserExist: string;
  public logo: string;
  public loading: string;
  public load: boolean;
  public user: User;
  public serverConected: boolean;

  constructor(private router: Router, private service: LoginService) {
    this.logo = Path.logo;
    this.notuser = false;
    this.notpass = false;
    this.notuserexist = false;
    this.load = false;
    this.loading = Path.loading;
    this.serverConected = true;
    this.notUserEmpty = Mensaje.notUserEmpty;
    this.notPassEmpty = Mensaje.notPassEmpty;
    this.notUserExist = Mensaje.notUserExist;
    this.user = new User();
    this.registration = false;
  }

  ngOnInit() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
    if (this.authentication) {
      this.router.navigate(['main']);
    }
  }

  ngDoCheck() {
    const register = localStorage.getItem('registration');
    if (register === 'true') {
      this.registration = true;
    } else {
      this.registration = false;
    }
  }

  private getAuth(auth: string) {
    if (auth === 'true') {
      this.authentication = true;
    } else {
      this.authentication = false;
    }
  }

  public login() {
    this.serverConected = true;
    if (this.user.nickname === undefined || this.user.nickname.trim() === '' || this.user.nickname.length === 0) {
      this.notUser(1);
    } else if (this.user.password === undefined || this.user.password.trim() === '' || this.user.password.length === 0) {
      this.notUser(3);
    } else if (this.user.nickname.length >= 0) {
      this.load = true;
      this.authenticationByNickname(this.user.nickname, this.user.password);
    }
  }

  public prueba(event: any) {

  }
  public register() {
    localStorage.setItem('registration', 'true');
  }

  authenticationByNickname(nickname: string, password: string) {
    this.service.findUserByNickname(nickname).subscribe(data => {
      if (data !== null) {
        const user = new User();
        user.cusuario = data.cusuario;
        user.nickname = data.nickname;
        user.password = password;
        this.authenticationLogin(user);
      } else {
        this.load = false;
        this.notUser(2);
      }
    }, error => {
      this.load = false;
      this.serverConected = false;
  });
  }

  authenticationLogin(user: User) {
    this.service.authenticationLogin(user).subscribe(data => {
      this.load = false;
      if (data != null) {
        this.user = data;
        this.setAuthentication();
      } else {
        this.notUser(2);
      }
    });
  }

  setAuthentication() {
    this.authentication = true;
    localStorage.setItem('nickname', this.user.nickname);
    localStorage.setItem('password', this.user.password);
    localStorage.setItem('authentication', 'true');
    this.router.navigate(['main']);
  }

  notUser(id: number) {
    if (id === 1) {
      this.notuserexist = false;
      this.notpass = false;
      this.notuser = true;
    } else if (id === 2) {
      this.notuser = false;
      this.notpass = false;
      this.notuserexist = true;
    } else if (id === 3) {
      this.notuser = false;
      this.notpass = true;
      this.notuserexist = false;
    }
  }

  closeSpan() {
    this.user.nickname = '';
    this.user.password = '';
    this.notuserexist = false;
    this.serverConected = true;
    this.notuser = false;
    this.notpass = false;
  }
}
