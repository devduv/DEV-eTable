import { Component, OnInit } from '@angular/core';
import { ReservacionService } from 'src/app/services/administracion/reservacion/reservacion.service';
import { Reservacion } from 'src/app/domain/Reservacion';
import { Mensaje } from 'src/app/infrastructure/constans/Mensaje';
import { Router, ActivatedRoute } from '@angular/router';
import { Cliente } from 'src/app/domain/Cliente';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-cliente-reservar',
  templateUrl: './cliente-reservar.component.html',
  styleUrls: ['./cliente-reservar.component.css']
})
export class ClienteReservarComponent implements OnInit {
  public empty: boolean;
  public reservacion: Reservacion;
  public cliente : Cliente;
  constructor(private activedRouter: ActivatedRoute,private router: Router,private service: ReservacionService) { 
    this.empty = false;
    this.reservacion = new Reservacion();
  }

  ngOnInit() {

  }
  private isEmpytNum(info: number, msg: string) {
    if (info === undefined || info == 0) {
      // this.successText = msg;
      return true;
    }
  }
  private isEmpytText(info: string, msg: string) {
    if (info === undefined || info.trim().length === 0) {
      // this.successText = msg;
      return true;
    }
  }
  private isEmpty() {
    if (this.isEmpytText(this.reservacion.fecha, Mensaje.emptyFecha)) {
      return true;
    }
    if (this.isEmpytText(this.reservacion.hora, Mensaje.emptyHora)) {
      return true;
    }
    if (this.isEmpytNum(this.reservacion.cantidad, Mensaje.emptyCantidad)) {
      return true;
    }
 
  }
  private obtenerClientebyUsuario() :number {
   
      var cusuario = Number(localStorage.getItem('cusuario'));
      
        this.service.obtenerClientebyUsuario(cusuario).subscribe(o => {
          if (o !== null) {
            this.cliente = o;
            
            console.log("cliente ",this.cliente);
           return this.cliente.ccliente ;
             } else { 
                this.navigateList();  
            
            }
       
      } ) ; 
      return 0;  
  }

  public register() {
    this.empty = this.isEmpty();
    if (!this.empty) {

      console.log("Resrevb", this.reservacion);
      var ccliente = this.obtenerClientebyUsuario();
      this.reservacion.ccliente = ccliente; //local storage
      this.reservacion.cestado = 1;
      this.reservacion.confirmada = false;
      this.service.crearReservacion(this.reservacion).subscribe(o => {
        console.log(o);

        // Swal.fire({
        //   position: 'top-end',
        //   icon: 'success',
        //   title: 'Your work has been saved',
        //   showConfirmButton: false,
        //   timer: 1500
        // })

        this.navigateList();
      });
    }
  }
  private navigateList() {
    this.router.navigate(['main']);
  }

}
