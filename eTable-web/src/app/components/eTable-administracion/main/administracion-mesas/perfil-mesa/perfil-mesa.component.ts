import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PerfilMesasService } from 'src/app/services/administracion/administracion-mesas/perfil-mesas.service';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { Path } from 'src/app/infrastructure/constans/Path';

@Component({
  selector: 'app-perfil-mesa',
  templateUrl: './perfil-mesa.component.html',
  styleUrls: ['./perfil-mesa.component.css']
})
export class PerfilMesaComponent implements OnInit {


    // configuracion: Configuracion;
    // prevconfiguracion: Configuracion;
    // load: boolean;
     edit: boolean;
    // saving: boolean;
    // loading: string;
     btn: string;
    // empty: boolean;
    // emptyText: string;
    // diasAtencion: any[];
    // dias: any[];
    success: boolean;
    // successText: string;


  public perfiles: PerfilMesa[];
  load: boolean;
  loading: string;
  constructor(private router: Router, private service: PerfilMesasService) {
    this.load = true;
    this.loading = Path.loading;
    console.log("path",this.loading);
  }

  ngOnInit() {
    this.service.getPerfilesMesa().subscribe(data => {
      this.load = false;
      console.log("data",data);
      if (data.length !== 0) {
        this.perfiles = data;
      }
    });
  }

  editar() {
    this.edit = !this.edit;
    this.success = false;
    this.btn = 'Guardar';
  }

  nuevoPerfil() {
    this.router.navigate(['mesas/perfiles/crear']);
  }
}
