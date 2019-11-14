import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  estado: boolean;
  constructor(private router: Router) {
    this.estado = false;
   }

  ngOnInit() {
  }

  cambiarEstadoUsuario(id: number, estado: boolean) {
    this.estado = !this.estado;
  }

  nuevoUsuario() {
    this.router.navigate(['usuarios/crear']);
  }
}
