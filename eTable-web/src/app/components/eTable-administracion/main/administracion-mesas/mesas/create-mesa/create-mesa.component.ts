import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { PerfilMesasService } from 'src/app/services/administracion/administracion-mesas/perfil-mesas.service';
import { EstadoMesasService } from 'src/app/services/administracion/administracion-mesas/estado-mesas.service';
import { MesasService } from 'src/app/services/administracion/administracion-mesas/mesas.service';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';
import { Path } from 'src/app/infrastructure/constans/Path';
import { Mesa } from 'src/app/domain/Mesa';
import { EstadoMesa } from 'src/app/domain/EstadoMesa';
@Component({
  selector: 'app-create-mesa',
  templateUrl: './create-mesa.component.html',
  styleUrls: ['./create-mesa.component.css']
})
export class CreateMesaComponent implements OnInit {

  public mesa: Mesa;
  public perfilmesa : PerfilMesa[];
  public estadomesa : EstadoMesa[];
  public load: boolean;
  public loading: string;
  public empty: boolean;
  public successText: string;
  public pmcompuesta : boolean;
  public selectedTypeId : number;
  constructor(private router: Router,  private servicePerfilMesas: PerfilMesasService,
    private estadoMesasService: EstadoMesasService , private mesasService: MesasService )  {
    this.mesa = new Mesa();
    this.selectedTypeId = 0;
    this.load = true;
    this.empty = false;
    this.loading = Path.loading;
  }

  ngOnInit() {
   
    this.getPerfilesMesa();
    this.getEstadosMesa();
  }
 
  private crearMesa() {
   /* this.mesa.cestadomesa = ;
    this.mesa.cperfilmesa = ;
    this.mesasService.crearMesa(this.mesa)
      .subscribe(o => {
        this.load = false;
        if (o) {
          console.log("o ",o);
          this.navigateList();
        } else {
          this.empty = true;
          this.successText = 'El nombre de mesa ya existe, pruebe otro.';
        }
      }); */
  }

  private isEmpytText(info: string, msg: string) {
    if (info === undefined || info.trim().length === 0) {
      this.successText = msg;
      return true;
    }
  }
  private isEmpytNum(info: number, msg: string) {
    if (info === undefined || info == 0) {
      this.successText = msg;
      return true;
    }
  }

  private isEmpty() {
    /*
    if (this.isEmpytText(this.perfilMesa.pmnombre, Mensaje.emptyNomMesa)) {
      return true;
    }
    if (this.isEmpytText(this.perfilMesa.pmdescripcion, Mensaje.emptyDescMesa)) {
      return true;
    }
    if (this.isEmpytNum(this.perfilMesa.pmcapacidad, Mensaje.emptyCapacMesa)) {
      return true;
    }*/
    
  
  }

  guardar(){ /*
    this.empty = this.isEmpty();
    if (!this.empty) {
      this.load = true;
     
      if(this.pmcompuesta) this.perfilMesa.pmcompuesta = 1;
      else  this.perfilMesa.pmcompuesta = 0;
      console.log(this.perfilMesa);
      this.crearPerfilMesa();
    }*/
    
  }
  private crearPerfilMesa() { /*
    this.servicePerfilMesas.crearPerfilMesa(this.perfilMesa)
      .subscribe(o => {
        console.log("o",o);
        this.load = false;
        if (o) {
          this.navigateList();
        } else {
          console.log("e22");
          this.empty = true;
          this.successText = 'El nombre de mesa ya existe, pruebe otro.';
        }
      });*/
  }
  cancelar(){
    this.navigateList();
  }

  private navigateList() {
    this.router.navigate(['mesas/list']);
  }

  private getPerfilesMesa() {
    this.servicePerfilMesas.getPerfilesMesa().subscribe(data => {
      this.perfilmesa = data;
      this.load = false;
    });
  }
  private getEstadosMesa() {
    this.estadoMesasService.getEstadosMesas().subscribe(data => {
      this.estadomesa = data;
      this.load = false;
    });
  }

  
}
