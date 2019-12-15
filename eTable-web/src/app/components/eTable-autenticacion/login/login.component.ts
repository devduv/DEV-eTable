import { Component, OnInit, Input, Output, DoCheck } from '@angular/core';
import { Router } from '@angular/router';
import { Path } from 'src/app/infrastructure/constans/Path';
import { User } from 'src/app/domain/User';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';
import { LoginService } from 'src/app/services/authentication/login.service';
import { SistemaGeneralService } from 'src/app/services/administracion/sistema/sistema-general.service';
import { Configuracion } from 'src/app/domain/Configuracion';
import { MatDialog } from '@angular/material/dialog';
import { UsuarioDeshabilitadoComponent } from '../../eTable-modals/usuario/usuario-deshabilitado/usuario-deshabilitado.component';
import { UsuarioService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';

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
  public config: Configuracion;

  constructor(
    private router: Router,
    private service: LoginService,
    private serviceConfig: SistemaGeneralService,
    private dialog: MatDialog,
    private serviceUser: UsuarioService) {
    // this.logo = Path.logo;
    this.notuser = false;
    this.notpass = false;
    this.notuserexist = false;
    this.load = true;
    this.loading = Path.loading;
    this.serverConected = true;
    this.notUserEmpty = Mensaje.notUserEmpty;
    this.notPassEmpty = Mensaje.notPassEmpty;
    this.notUserExist = Mensaje.notUserExist;
    this.user = new User();
    this.registration = false;
    this.config = new Configuracion();
  }

  ngOnInit() {
    this.getConfiguracion();
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

  public openDialog(data: User) {
    const dialogRef = this.dialog.open(UsuarioDeshabilitadoComponent, {
      width: '250px',
      data: data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  public register() {
    localStorage.setItem('emplogo',  this.config.emplogo);
    localStorage.setItem('empnombre', this.config.empnombre);
    localStorage.setItem('registration', 'true');
  }

  private authenticationByNickname(nickname: string, password: string) {
    this.service.findUserByNickname(nickname).subscribe(data => {
      if (data !== null) {
        const user = new User();
        user.cusuario = data.cusuario;
        user.nickname = data.nickname;
        user.password = password;
        this.authenticationLogin(user, password);
      } else {
        this.load = false;
        this.notUser(2);
      }
    }, error => {
      if (error) {
        this.load = false;
        this.serverConected = false;
      }
    });
  }

  private authenticationLogin(user: User, password: string) {
    this.service.authenticationLogin(user).subscribe(data => {
      this.load = false;
      if (data != null) {
        this.user = data;
        this.setAuthentication(password);
      } else {
        this.notUser(4);
      }
    });
  }

  private setAuthentication(password: string) {
    const passwordHash = this.user.password;
    this.user.password = password;
    if (this.user.estado) {
      this.authentication = true;
      localStorage.setItem('nickname', this.user.nickname);
      localStorage.setItem('password', passwordHash);
      localStorage.setItem('authentication', 'true');
      // localStorage.setItem('ccliente', this.user.nickname);
      // localStorage.setItem('ctipousuario', passwordHash);
      this.router.navigate(['main']);
    } else {
      const us = new User();
      us.nickname = this.user.nickname;
      us.password = passwordHash;
      this.serviceUser.getUsuarioByAuthentication(us).subscribe(data => {
      this.openDialog(data);
      });
    }
  }

  private notUser(id: number) {
    if (id === 1) {
      this.setBoolean(true, false, false);
    } else if (id === 2) {
      this.setBoolean(false, false, true);
    } else if (id === 3) {
      this.setBoolean(false, true, false);
    } else if (id === 4) {
      this.setBoolean(false, false, true);
      this.notUserExist = Mensaje.wrongPass;
    }
  }

  private setBoolean(notus: boolean, notp: boolean, notuse: boolean) {
    this.notuser = notus;
    this.notpass = notp;
    this.notuserexist = notuse;
  }

  public closeSpan() {
    this.user.nickname = '';
    this.user.password = '';
    this.notuserexist = false;
    this.serverConected = true;
    this.notuser = false;
    this.notpass = false;
  }

  private getConfiguracion() {
    console.log('Cargando imagen...');
    this.serviceConfig.getConfiguracionSistemaGeneral().subscribe(data => {
      this.config = data;
      if (this.config.empnombre.length === 0) {
        this.config.empnombre = 'Bienvenido, Reserva tu mesa';
      }
      if (this.config.emplogo.length !== 0) {
        this.logo = '../../' + this.config.emplogo;
      } else {
        this.logo = Path.logo;
        console.log('lol',  this.logo);
      }
      
      this.load = false;
    }, error => {
      if (error) {
        console.log('lol',  this.logo);
        this.load = false;
        this.serverConected = false;
      }
    });
  }

}
