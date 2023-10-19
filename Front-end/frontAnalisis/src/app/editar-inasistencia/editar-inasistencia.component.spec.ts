import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarInasistenciaComponent } from './editar-inasistencia.component';

describe('EditarInasistenciaComponent', () => {
  let component: EditarInasistenciaComponent;
  let fixture: ComponentFixture<EditarInasistenciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarInasistenciaComponent]
    });
    fixture = TestBed.createComponent(EditarInasistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
