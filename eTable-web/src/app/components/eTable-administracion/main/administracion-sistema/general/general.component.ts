import { Component, OnInit } from '@angular/core';
import { SistemaGeneralService } from 'src/app/services/administracion/sistema/sistema-general.service';
import { Configuracion } from 'src/app/domain/Configuracion';
import { Path } from 'src/app/infrastructure/constans/Path';

@Component({
  selector: 'app-general',
  templateUrl: './general.component.html',
  styleUrls: ['./general.component.css']
})
export class GeneralComponent implements OnInit {

  configuracion: Configuracion;
  load: boolean;
  loading: string;


  constructor(private service: SistemaGeneralService) {
    this.configuracion = new Configuracion();
    this.loading = Path.loading;
    this.load = true;
  }

  ngOnInit() {
    this.configuracion = new Configuracion();
    this.getConfiguracionSistemaGeneral();
  }

  getConfiguracionSistemaGeneral() {
    this.service.getConfiguracionSistemaGeneral().subscribe(data => {
      this.load = false;
      if (data != null) {
        this.configuracion = data;
        this.initConfig();
      }
    });
  }

  habilitar(id: number) {
    switch (id) {
      case 1:
        this.configuracion.sist_reservacion_cliente = !this.configuracion.sist_reservacion_cliente;
        this.setValorButton(this.configuracion.sist_reservacion_cliente, 'sistreservacioncliente');
        break;
      case 2:
        this.configuracion.sist_atencion_cliente = !this.configuracion.sist_atencion_cliente;
        this.setValorButton(this.configuracion.sist_atencion_cliente, 'sistatencioncliente');
        break;
      case 3:
        this.configuracion.mesas_compuestas = !this.configuracion.mesas_compuestas;
        this.setValorButton(this.configuracion.mesas_compuestas, 'mesascompuestas');
        break;
      case 4:
        this.configuracion.reservacion_pedidos = !this.configuracion.reservacion_pedidos;
        this.setValorButton(this.configuracion.reservacion_pedidos, 'reservacionpedidos');
        break;
      case 5:
        this.configuracion.reservas_no_sesionadas = !this.configuracion.reservas_no_sesionadas;
        this.setValorButton(this.configuracion.reservas_no_sesionadas, 'reservasnosesionadas');
        break;
      case 6:
        this.configuracion.agregar_cliente_manual = !this.configuracion.agregar_cliente_manual;
        this.setValorButton(this.configuracion.agregar_cliente_manual, 'agregarclientemanual');
        break;
      case 7:
        this.configuracion.reservas_especiales = !this.configuracion.reservas_especiales;
        this.setValorButton(this.configuracion.reservas_especiales, 'reservasespeciales');
        break;
      case 8:
        this.configuracion.pagos_tarjeta_credito = !this.configuracion.pagos_tarjeta_credito;
        this.setValorButton(this.configuracion.pagos_tarjeta_credito, 'pagostarjetacredito');
        break;
    }
  }

  setValorButton(habilitado: boolean, buttonId: string) {
    const button = document.getElementById(buttonId);
    if (habilitado) {
      button.innerText = 'Habilitado';
    } else {
      button.innerText = 'Deshabilitado';
    }
  }

  initConfig() {
    this.setValorButton(this.configuracion.sist_reservacion_cliente, 'sistreservacioncliente');
    this.setValorButton(this.configuracion.sist_atencion_cliente, 'sistatencioncliente');
    this.setValorButton(this.configuracion.mesas_compuestas, 'mesascompuestas');
    this.setValorButton(this.configuracion.reservacion_pedidos, 'reservacionpedidos');
    this.setValorButton(this.configuracion.reservas_no_sesionadas, 'reservasnosesionadas');
    this.setValorButton(this.configuracion.agregar_cliente_manual, 'agregarclientemanual');
    this.setValorButton(this.configuracion.reservas_especiales, 'reservasespeciales');
    this.setValorButton(this.configuracion.pagos_tarjeta_credito, 'pagostarjetacredito');
  }

  guardarCambios() {
    console.log('Cambios guardados.');
  }
}
