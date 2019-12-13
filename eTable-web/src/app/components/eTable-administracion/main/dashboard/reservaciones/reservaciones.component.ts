import { Component, OnInit } from '@angular/core';
import { MesasService } from 'src/app/services/administracion/administracion-mesas/mesas.service';
import { Mesa } from 'src/app/domain/Mesa';

@Component({
  selector: 'app-reservaciones',
  templateUrl: './reservaciones.component.html',
  styleUrls: ['./reservaciones.component.css']
})
export class ReservacionesComponent implements OnInit {

  public mesas: Mesa[];
  constructor(private serviceMesa: MesasService) { }

  ngOnInit() {
  }

  private getMesas() {
    this.serviceMesa.getMesas().subscribe(data => {
      this.mesas = data;
    });
  }

}
