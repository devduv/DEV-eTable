import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MesasService } from 'src/app/services/administracion/administracion-mesas/mesas.service';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { Path } from 'src/app/infrastructure/constans/Path';
import { PerfilMesasService } from 'src/app/services/administracion/administracion-mesas/perfil-mesas.service';

@Component({
  selector: 'app-perfil-mesa',
  templateUrl: './perfil-mesa.component.html',
  styleUrls: ['./perfil-mesa.component.css']
})
export class PerfilMesaComponent implements OnInit {


  public perfiles: PerfilMesa[];
  load: boolean;
  loading: string;
  constructor(private router: Router, private service: PerfilMesasService) {
    this.load = true;
    this.loading = Path.loading;
  }

  ngOnInit() {
    this.obtenerPerfilesMesa();
  }

  nuevoPerfil() {
    this.router.navigate(['mesas/perfiles/crear']);
  }

  obtenerPerfilesMesa(){
    this.service.getPerfilesMesa().subscribe(data => 
      { 
       this.load=false;
       this.perfiles=data;
       }
    )
  }


}
