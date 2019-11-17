import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mesas',
  templateUrl: './mesas.component.html',
  styleUrls: ['./mesas.component.css']
})
export class MesasComponent implements OnInit {
  estado: boolean;

   constructor(private router: Router) {
     this.estado = false;
    }

  ngOnInit() {
  }

  
  cambiarEstadoMesa(id: number, estado: boolean) {
    this.estado = !this.estado;
  }

  nuevaMesa() {
    this.router.navigate(['mesas/crear']);
  }

}
