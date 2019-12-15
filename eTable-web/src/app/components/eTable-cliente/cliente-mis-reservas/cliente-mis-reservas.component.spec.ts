import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteMisReservasComponent } from './cliente-mis-reservas.component';

describe('ClienteMisReservasComponent', () => {
  let component: ClienteMisReservasComponent;
  let fixture: ComponentFixture<ClienteMisReservasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClienteMisReservasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteMisReservasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
