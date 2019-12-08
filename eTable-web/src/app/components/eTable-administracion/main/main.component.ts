import { Component, OnInit, Input, DoCheck } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/domain/User';
import { UsuarioService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  public authentication: boolean;
  public user: User;
  constructor(private router: Router, private service: UsuarioService) { 
    this.user = new User();
  }

  ngOnInit() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
  }

  getAuth(auth: string) {
    if (auth === 'true') {
      this.getUserName();
      this.authentication = true;
    } else {
      this.authentication = false;
    }
  }

  private getUserName() {
    this.user.nickname = localStorage.getItem('nickname').toString();
    this.user.password = localStorage.getItem('password').toString();
    this.service.getUsuarioByAuthentication(this.user).subscribe(o => {
      if (o !== null) {
        this.user = o;
      }
    });
  }

}
