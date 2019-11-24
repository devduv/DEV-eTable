import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PermisosService } from 'src/app/services/administracion/administracion-usuarios/permisos.service';
import { Permiso } from 'src/app/domain/Permiso';
import { Path } from 'src/app/infrastructure/constans/Path';

@Component({
  selector: 'app-editar',
  templateUrl: './editar-permiso.component.html',
  styleUrls: ['./editar-permiso.component.css']
})
export class EditarPermisoComponent implements OnInit {

  permiso: Permiso;
  load: boolean;
  loading: string;

  constructor(private router: Router, private service: PermisosService) {
    this.permiso = new Permiso();
    this.load = true;
    this.loading = Path.loading;
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
      if (data !== null) {
        this.load = false;
        this.permiso = data;
      }
    });
  }

  actualizarPermiso(permiso: Permiso) {
    this.service.actualizarPermiso(permiso).subscribe(data => {
      if ( data !== null) {

      }
    });
  }
}
