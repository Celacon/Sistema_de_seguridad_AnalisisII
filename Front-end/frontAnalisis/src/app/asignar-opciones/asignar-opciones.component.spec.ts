import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignarOpcionesComponent } from './asignar-opciones.component';

describe('AsignarOpcionesComponent', () => {
  let component: AsignarOpcionesComponent;
  let fixture: ComponentFixture<AsignarOpcionesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsignarOpcionesComponent]
    });
    fixture = TestBed.createComponent(AsignarOpcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
