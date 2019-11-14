import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilMesaComponent } from './perfil-mesa.component';

describe('PerfilMesaComponent', () => {
  let component: PerfilMesaComponent;
  let fixture: ComponentFixture<PerfilMesaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilMesaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilMesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
