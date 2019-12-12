import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mesa } from 'src/app/domain/Mesa';
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
  public id: number;
  mesas: Mesa[];
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
       this.mesas =data;
       console.log(this.mesas);

        for (let i = 0; i < this.mesas.length; i++) {
          console.log("le paso ",this.mesas[i].cmesa)
          var prueba = this.obtenerEstadoMesas(this.mesas[i].cestadomesa);
          console.log("pr > " , prueba);
          this.mesas[i].tipoestado = prueba;

          console.log(this.mesas[i] );
        } }
    )}
  public obtenerEstadoMesas(i : number){
    this.id=i;
    var descEstado = "A";
    this.serviceestadomesa.obtenerEstadoMesa(this.id).subscribe(o => {
      if (o !== null) {
        this.estadomesa = o;
        console.log("this.estadomesa",this.estadomesa);
        descEstado =this.estadomesa.emdescripcion;
        console.log("this.descEstado",this.estadomesa.emdescripcion);
      return o;
  }  });
     return descEstado;
}
  cambiarEstadoMesa(id: number, estado: boolean) {
    this.estado = !this.estado;
  }

  nuevaMesa() {
    this.router.navigate(['mesas/crear']);
  }

}
