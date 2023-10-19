import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarFlujoStatusEmpleadoComponent } from './agregar-flujo-status-empleado.component';

describe('AgregarFlujoStatusEmpleadoComponent', () => {
  let component: AgregarFlujoStatusEmpleadoComponent;
  let fixture: ComponentFixture<AgregarFlujoStatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarFlujoStatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(AgregarFlujoStatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
