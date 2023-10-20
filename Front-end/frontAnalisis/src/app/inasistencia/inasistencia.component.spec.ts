import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InasistenciaComponent } from './inasistencia.component';

describe('InasistenciaComponent', () => {
  let component: InasistenciaComponent;
  let fixture: ComponentFixture<InasistenciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InasistenciaComponent]
    });
    fixture = TestBed.createComponent(InasistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
