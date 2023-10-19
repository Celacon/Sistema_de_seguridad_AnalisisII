import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarEstatusEmpleadoComponent } from './editar-estatus-empleado.component';

describe('EditarEstatusEmpleadoComponent', () => {
  let component: EditarEstatusEmpleadoComponent;
  let fixture: ComponentFixture<EditarEstatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarEstatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(EditarEstatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
