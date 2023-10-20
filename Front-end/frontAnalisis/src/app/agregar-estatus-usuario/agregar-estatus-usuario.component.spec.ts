import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarEstatusUsuarioComponent } from './agregar-estatus-usuario.component';

describe('AgregarEstatusUsuarioComponent', () => {
  let component: AgregarEstatusUsuarioComponent;
  let fixture: ComponentFixture<AgregarEstatusUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarEstatusUsuarioComponent]
    });
    fixture = TestBed.createComponent(AgregarEstatusUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
