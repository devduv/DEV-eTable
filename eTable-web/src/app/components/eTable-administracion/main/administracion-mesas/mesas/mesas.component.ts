import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mesa } from 'src/app/domain/Mesa';
import { MesaDTO } from 'src/app/domain/MesaDTO';
import { MesasService } from 'src/app/services/administracion/administracion-mesas/mesas.service';
import { EstadoMesa } from 'src/app/domain/EstadoMesa';
import { EstadoMesasService } from 'src/app/services/administracion/administracion-mesas/estado-mesas.service';

@Component({
  selector: 'app-mesas',
  templateUrl: './mesas.component.html',
  styleUrls: ['./mesas.component.css']
})
export class MesaComponent implements OnInit {
  estado: boolean;
  prueba : string;
  public id: number;
  mesas: Mesa[];
  mesasdto: MesaDTO[];
  estadomesa : EstadoMesa;
  load: boolean;
  loading: string;
   constructor(private router: Router, private serviceMesas: MesasService , 
    private serviceestadomesa: EstadoMesasService ) {
     this.estado = false;
    }

  ngOnInit() {
    this.obtenerMesas();
   
  }
  
  obtenerMesas(){
    this.serviceMesas.getMesas().subscribe(data => 
      { 
       this.load=false;
       this.mesasdto = data;
       console.log("MESAS" ,this.mesasdto);
/*
        for (let i = 0; i < this.mesas.length; i++) {
          console.log("le paso ",this.mesas[i].cestadomesa)
           this.prueba  = this.obtenerEstadoMesas(this.mesas[i].cestadomesa);
          console.log("pr > " , this.prueba);
          this.mesas[i].tipoestado = this.prueba;

          console.log(this.mesas[i] );
        } */
      } 
    )}
    /*
  public obtenerEstadoMesas(i : number){
    this.id=i;
    var descEstado ='A';
    switch (i) {
    case 1:
        descEstado='Habilitada';
        ;
        break;
      case 2:
        descEstado='En re[aracion';
        
        break;
      case 3:
        descEstado='Desuso';
       break;
    }
    return descEstado;
}*/
// obtenerPerfilMesas
// public obtenerEstadoMesas(i : number) : string {
//   this.id=i;
//   var descPerfil ='A';
//    var descEstado = "aaaA";
//   this.serviceestadomesa.obtenerEstadoMesa(this.id).subscribe(o => {
//     if (o !== null) {
//       this.estadomesa = o;
//       console.log("this.estadomesa",this.estadomesa);
//       descEstado =this.estadomesa.emdescripcion;
//       console.log("this.descEstadoooo", descEstado);
     
//       return descEstado;
//      } 
//     })
     
//      ;
//     return descEstado;
// }

  cambiarEstadoMesa(id: number, estado: boolean) {
    this.estado = !this.estado;
  }

  nuevaMesa() {
    this.router.navigate(['mesas/crear']);
  }

}
