import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCuentaBancariaEmpleadoComponent } from './editar-cuenta-bancaria-empleado.component';

describe('EditarCuentaBancariaEmpleadoComponent', () => {
  let component: EditarCuentaBancariaEmpleadoComponent;
  let fixture: ComponentFixture<EditarCuentaBancariaEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarCuentaBancariaEmpleadoComponent]
    });
    fixture = TestBed.createComponent(EditarCuentaBancariaEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
