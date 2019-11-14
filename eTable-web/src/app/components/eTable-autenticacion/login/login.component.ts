import { Component, OnInit, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Path } from 'src/app/infrastructure/constans/Path';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Input() @Output()
  public authentication: boolean;

  public logo: string;

  constructor(private router: Router) {
    this.logo = Path.logo;
   }

  ngOnInit() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
    if (this.authentication) {
      this.router.navigate(['main']);
    }
  }

  getAuth(auth: string) {
    if (auth === 'true') {
      this.authentication = true;
    } else {
      this.authentication = false;
    }
  }

  login() {
    this.authentication = true;
    localStorage.setItem('authentication', 'true');
    this.router.navigate(['main']);
  }
}
