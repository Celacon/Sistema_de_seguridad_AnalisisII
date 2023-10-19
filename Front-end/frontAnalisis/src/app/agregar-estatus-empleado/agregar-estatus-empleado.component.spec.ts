import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarEstatusEmpleadoComponent } from './agregar-estatus-empleado.component';

describe('AgregarEstatusEmpleadoComponent', () => {
  let component: AgregarEstatusEmpleadoComponent;
  let fixture: ComponentFixture<AgregarEstatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarEstatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(AgregarEstatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
