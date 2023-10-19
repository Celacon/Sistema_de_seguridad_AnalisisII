import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarOpcionesComponent } from './editar-opciones.component';

describe('EditarOpcionesComponent', () => {
  let component: EditarOpcionesComponent;
  let fixture: ComponentFixture<EditarOpcionesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarOpcionesComponent]
    });
    fixture = TestBed.createComponent(EditarOpcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
