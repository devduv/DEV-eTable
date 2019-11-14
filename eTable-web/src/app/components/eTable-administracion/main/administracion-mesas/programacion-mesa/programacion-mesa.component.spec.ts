import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramacionMesaComponent } from './programacion-mesa.component';

describe('ProgramacionMesaComponent', () => {
  let component: ProgramacionMesaComponent;
  let fixture: ComponentFixture<ProgramacionMesaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgramacionMesaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramacionMesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
