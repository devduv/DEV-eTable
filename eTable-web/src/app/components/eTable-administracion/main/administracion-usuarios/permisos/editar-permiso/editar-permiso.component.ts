import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PermisosService } from 'src/app/services/administracion/administracion-usuarios/permisos.service';
import { Permiso } from 'src/app/domain/Permiso';

@Component({
  selector: 'app-editar',
  templateUrl: './editar-permiso.component.html',
  styleUrls: ['./editar-permiso.component.css']
})
export class EditarPermisoComponent implements OnInit {

  public permiso: Permiso;

  duvan: boolean;

  constructor(private router: Router, private service: PermisosService) {
    this.permiso = new Permiso();
   }

  ngOnInit() {
    this.getPermisoIdLocalStorage();
  }

  getPermisoIdLocalStorage() {
    const id = localStorage.getItem('permisoId');
    this.getPermisoById(+id);
  }

  getPermisoById(id: number) {
    this.service.getPermisoById(id).subscribe(data => {
      this.permiso = data;
    });
  }

  actualizarPermiso(permiso: Permiso) {
    this.service.actualizarPermiso(permiso).subscribe(data => {
      if ( data !== null) {

      }
    });
  }
}
