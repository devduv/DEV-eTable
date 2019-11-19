import { Component, OnInit } from '@angular/core';
import { Configuracion } from 'src/app/domain/Configuracion';
import { Path } from 'src/app/infrastructure/constans/Path';
import { SistemaGeneralService } from 'src/app/services/administracion/sistema/sistema-general.service';

@Component({
  selector: 'app-configuracion',
  templateUrl: './configuracion.component.html',
  styleUrls: ['./configuracion.component.css']
})
export class ConfiguracionComponent implements OnInit {

  configuracion: Configuracion;
  prevconfiguracion: Configuracion;
  load: boolean;
  edit: boolean;
  saving: boolean;
  loading: string;
  btn: string;
  empty: boolean;
  emptyText: string;

  constructor(private service: SistemaGeneralService) {
    this.configuracion = new Configuracion();
    this.prevconfiguracion = new Configuracion();
    this.loading = Path.loading;
    this.edit = true;
    this.load = true;
    this.saving = false;
    this.btn = 'Editar';
    this.empty = false;
   }

  ngOnInit() {
    this.getConfiguracionParametros();
  }

  getConfiguracionParametros() {
    this.service.getConfiguracionParametros().subscribe(data => {
      console.log(data);
      if (data != null) {
        this.load = false;
        this.configuracion.setParametros(data);
      }
    });
  }
  guardarCambios() {

  }

  editar() {
    this.edit = !this.edit;
    this.btn = 'Guardar';
  }

  cancelar() {
    this.btn = 'Editar';
    this.edit = !this.edit;
    this.empty = false;
  }

}
