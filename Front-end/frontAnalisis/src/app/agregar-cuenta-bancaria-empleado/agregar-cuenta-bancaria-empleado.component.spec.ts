import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarCuentaBancariaEmpleadoComponent } from './agregar-cuenta-bancaria-empleado.component';

describe('AgregarCuentaBancariaEmpleadoComponent', () => {
  let component: AgregarCuentaBancariaEmpleadoComponent;
  let fixture: ComponentFixture<AgregarCuentaBancariaEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarCuentaBancariaEmpleadoComponent]
    });
    fixture = TestBed.createComponent(AgregarCuentaBancariaEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
