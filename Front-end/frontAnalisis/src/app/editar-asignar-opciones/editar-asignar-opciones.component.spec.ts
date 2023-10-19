import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAsignarOpcionesComponent } from './editar-asignar-opciones.component';

describe('EditarAsignarOpcionesComponent', () => {
  let component: EditarAsignarOpcionesComponent;
  let fixture: ComponentFixture<EditarAsignarOpcionesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarAsignarOpcionesComponent]
    });
    fixture = TestBed.createComponent(EditarAsignarOpcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
