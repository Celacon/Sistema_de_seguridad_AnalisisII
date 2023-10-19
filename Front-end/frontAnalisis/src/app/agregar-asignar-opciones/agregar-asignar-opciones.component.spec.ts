import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarAsignarOpcionesComponent } from './agregar-asignar-opciones.component';

describe('AgregarAsignarOpcionesComponent', () => {
  let component: AgregarAsignarOpcionesComponent;
  let fixture: ComponentFixture<AgregarAsignarOpcionesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarAsignarOpcionesComponent]
    });
    fixture = TestBed.createComponent(AgregarAsignarOpcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
