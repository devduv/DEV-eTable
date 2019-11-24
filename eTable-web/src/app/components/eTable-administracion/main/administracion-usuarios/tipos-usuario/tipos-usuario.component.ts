import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Path } from 'src/app/infrastructure/constans/Path';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { UsuariosService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';

@Component({
  selector: 'app-tiposusuario',
  templateUrl: './tipos-usuario.component.html',
  styleUrls: ['./tipos-usuario.component.css']
})
export class TiposUsuarioComponent implements OnInit {

  load: boolean;
  loading: string;
  tiposUsuario: TipoUsuario[];

  constructor(private router: Router, private service: UsuariosService) {
    this.load = true;
    this.loading = Path.loading;
   }

  ngOnInit() {
    this.getTiposUsuario();
  }

  nuevoTipoUsuario() {
    this.router.navigate(['usuarios/tipos/crear']);
  }

  getTiposUsuario() {
    this.service.getTiposUsuario().subscribe(data => {
      this.load = false;
      if (data.length !== 0) {
        this.tiposUsuario = data;
      }
      
    });
  }
}
