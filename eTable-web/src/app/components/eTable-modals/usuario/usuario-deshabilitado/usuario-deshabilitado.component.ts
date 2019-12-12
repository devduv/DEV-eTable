import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-usuario-deshabilitado',
  templateUrl: './usuario-deshabilitado.component.html'
})
export class UsuarioDeshabilitadoComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<UsuarioDeshabilitadoComponent>, @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  close() {
    console.log('oink');
    this.dialogRef.close();
  }
}
