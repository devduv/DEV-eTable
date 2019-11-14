import { Component, OnInit, Input, DoCheck } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit, DoCheck {

  public authentication: boolean;
  constructor(private router: Router) { }

  ngOnInit() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
  }

  ngDoCheck() {
    const auth = localStorage.getItem('authentication');
    this.getAuth(auth);
  }

  getAuth(auth: string) {
    if (auth === 'true') {
      this.authentication = true;
    } else {
      this.authentication = false;
    }
  }

}
