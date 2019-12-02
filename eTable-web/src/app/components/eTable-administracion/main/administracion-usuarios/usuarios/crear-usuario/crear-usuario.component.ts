import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuariosService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { User } from 'src/app/domain/User';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';

@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css']
})
export class CrearUsuarioComponent implements OnInit {

  public tiposUsuario: TipoUsuario[];
  public user: User;
  public empty: boolean;
  public successText: string;

  constructor(private router: Router, private serviceUsuario: UsuariosService) {
    this.user = new User();
    this.empty = false;
  }

  ngOnInit() {
    this.getTiposUsuario();
  }

  public cancelar() {
    this.navigateList();
  }

  public crearUsuario() {
    this.empty = this.isEmpty();
    if (!this.empty) {
      /*this.serviceUsuario.crearTipoUsuario().subscribe(data => {
      
          });*/
      this.navigateList();
    }

  }

  private navigateList() {
    this.router.navigate(['usuarios/list']);
  }

  private getTiposUsuario() {
    this.serviceUsuario.getTiposUsuario().subscribe(data => {
      this.tiposUsuario = data;
    });
  }

  private isEmpty() {
    if (this.isEmpytText(this.user.usnombres, Mensaje.emptyName)) {
      return true;
    }
    if (this.isEmpytText(this.user.usapellidos, Mensaje.emptyName)) {
      return true;
    }
    if (this.isEmpytText(this.user.email, Mensaje.emptyEmail)) {
      return true;
    }
    if (this.isEmpytText(this.user.phone, Mensaje.emptyPhone)) {
      return true;
    }
    if (this.isEmpytText(this.user.date, Mensaje.emptyDate)) {
      return true;
    }
    if (this.isEmpytText(this.user.dni, Mensaje.emptyDNI)) {
      return true;
    }
    if (this.isEmpytText(this.user.nickname, Mensaje.notUserEmpty)) {
      return true;
    }
    if (this.isEmpytText(this.user.password, Mensaje.emptyPass)) {
      return true;
    }

  }

  private isEmpytText(info: string, msg: string) {
    if (info === undefined || info.trim().length === 0) {
      this.successText = msg;
      return true;
    }
  }
}
