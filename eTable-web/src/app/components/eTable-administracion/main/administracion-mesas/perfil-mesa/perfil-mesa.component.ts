import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MesasService } from 'src/app/services/administracion/administracion-mesas/mesas.service';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';

@Component({
  selector: 'app-perfil-mesa',
  templateUrl: './perfil-mesa.component.html',
  styleUrls: ['./perfil-mesa.component.css']
})
export class PerfilMesaComponent implements OnInit {

  public perfiles: PerfilMesa[];
  constructor(private router: Router, private service: MesasService) { }

  ngOnInit() {
    this.service.getPerfilesMesa().subscribe(data => {
      if (data.length !== 0) {
        this.perfiles = data;
      }
    });
  }

  nuevoPerfil() {
    this.router.navigate(['mesas/perfiles/crear']);
  }
}
