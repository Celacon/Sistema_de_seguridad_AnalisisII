import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarOpcionesComponent } from './agregar-opciones.component';

describe('AgregarOpcionesComponent', () => {
  let component: AgregarOpcionesComponent;
  let fixture: ComponentFixture<AgregarOpcionesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarOpcionesComponent]
    });
    fixture = TestBed.createComponent(AgregarOpcionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
