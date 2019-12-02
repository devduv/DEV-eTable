import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuariosService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';
import { User } from 'src/app/domain/User';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  public usuarios: User[];
  estado: boolean;
  sinUsuarios: boolean;
  constructor(private router: Router, private service: UsuariosService) {
    this.estado = false;
    this.sinUsuarios = true;
   }

  ngOnInit() {
    this.getUsuarios();
  }

  cambiarEstadoUsuario(id: number, estado: boolean) {
    this.estado = !this.estado;
  }

  nuevoUsuario() {
    this.router.navigate(['usuarios/crear']);
  }

  private getUsuarios() {
    const user = new User();
    user.ctipousuario = 1;
    user.nickname = 'Admin';
    user.usnombres = 'DUvan';
    user.usapellidos = 'saenz';
    this.usuarios = [user];
    if (this.usuarios.length !== 0) {
      this.sinUsuarios = false;
    }
    /*this.service.getUsuarios().subscribe(data => {

    });*/
  }
}
