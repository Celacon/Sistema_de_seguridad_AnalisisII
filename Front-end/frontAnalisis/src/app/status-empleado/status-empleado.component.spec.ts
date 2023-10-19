import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusEmpleadoComponent } from './status-empleado.component';

describe('StatusEmpleadoComponent', () => {
  let component: StatusEmpleadoComponent;
  let fixture: ComponentFixture<StatusEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatusEmpleadoComponent]
    });
    fixture = TestBed.createComponent(StatusEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
