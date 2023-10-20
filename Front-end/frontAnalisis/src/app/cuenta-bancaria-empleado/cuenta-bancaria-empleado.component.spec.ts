import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuentaBancariaEmpleadoComponent } from './cuenta-bancaria-empleado.component';

describe('CuentaBancariaEmpleadoComponent', () => {
  let component: CuentaBancariaEmpleadoComponent;
  let fixture: ComponentFixture<CuentaBancariaEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CuentaBancariaEmpleadoComponent]
    });
    fixture = TestBed.createComponent(CuentaBancariaEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
