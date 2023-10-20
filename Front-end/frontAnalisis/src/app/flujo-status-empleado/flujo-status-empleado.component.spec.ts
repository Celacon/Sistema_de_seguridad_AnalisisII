import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlujoStatusEmpleadoComponent } from './flujo-status-empleado.component';

describe('FlujoStatusEmpleadoComponent', () => {
  let component: FlujoStatusEmpleadoComponent;
  let fixture: ComponentFixture<FlujoStatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlujoStatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(FlujoStatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
