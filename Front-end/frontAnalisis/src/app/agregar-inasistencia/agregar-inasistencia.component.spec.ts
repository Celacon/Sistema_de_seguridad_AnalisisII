import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarInasistenciaComponent } from './agregar-inasistencia.component';

describe('AgregarInasistenciaComponent', () => {
  let component: AgregarInasistenciaComponent;
  let fixture: ComponentFixture<AgregarInasistenciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarInasistenciaComponent]
    });
    fixture = TestBed.createComponent(AgregarInasistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
