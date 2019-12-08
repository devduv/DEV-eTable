import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { Path } from 'src/app/infrastructure/constans/Path';
import { PerfilMesasService } from 'src/app/services/administracion/administracion-mesas/perfil-mesas.service';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';

@Component({
  selector: 'app-create-perfil-mesa',
  templateUrl: './create-perfil-mesa.component.html',
  styleUrls: ['./create-perfil-mesa.component.css']
})
export class CreatePerfilMesaComponent implements OnInit {
  perfil: PerfilMesa ;
   // configuracion: Configuracion;
    // prevconfiguracion: Configuracion;
     load: boolean;
    edit: boolean;
    saving: boolean;
     loading: string;
     btn: string;
   empty: boolean;
     emptyText: string;
    // diasAtencion: any[];
    // dias: any[];
    success: boolean;
    successText: string;
    

   constructor(private router: Router, private service: PerfilMesasService) {
      
      this.perfil = new PerfilMesa() ;
      this.loading = Path.loading;
      this.load = false;
      this.saving = false;
      this.success = false;
      this.empty = false;
    }

  // constructor(private router: Router) {

  // }
  cancelar() {
    this.router.navigate(['mesas/perfiles']);
  }
  
  ngOnInit() {
    this.guardarCambios();
  
  }
  guardarCambios() {
    console.log("perfil: ",this.perfil);
    // this.load = true;
    // this.configuracion.dias_atencion = this.diasEnAtencion();
    // this.service.actualizarParametrosSistemaGeneral(this.configuracion).subscribe(data => {
    //   this.load = false;
      this.successText = Mensaje.successText;
    //   this.success = true;
    //   this.btn = 'Editar';
    //   this.edit = true;
    // });
  }


  // activarComposiciona(id: number) {
  //   this.dias[id].activo = !this.dias[id].activo;
  //  }

}
