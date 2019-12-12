import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
@Component({
  selector: 'app-create-perfil-mesa',
  templateUrl: './create-perfil-mesa.component.html',
  styleUrls: ['./create-perfil-mesa.component.css']
})
export class CreatePerfilMesaComponent implements OnInit {

  public perfilMesa: PerfilMesa;

  constructor(private router: Router) {
    this.perfilMesa = new PerfilMesa();
  }

  ngOnInit() {
    
  }

  guardar(){
    console.log(this.perfilMesa);
  }

  cancelar(){
    this.navigateList();
  }

  private navigateList() {
    this.router.navigate(['mesas/perfiles']);
  }

  public cambiarEstado() {
    this.perfilMesa.pmcompuesta = !this.perfilMesa.pmcompuesta;
  }
}
