import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarFlujoStatusEmpleadoComponent } from './editar-flujo-status-empleado.component';

describe('EditarFlujoStatusEmpleadoComponent', () => {
  let component: EditarFlujoStatusEmpleadoComponent;
  let fixture: ComponentFixture<EditarFlujoStatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarFlujoStatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(EditarFlujoStatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
