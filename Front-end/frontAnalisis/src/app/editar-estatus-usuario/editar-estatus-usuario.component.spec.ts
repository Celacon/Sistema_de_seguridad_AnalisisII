import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarEstatusUsuarioComponent } from './editar-estatus-usuario.component';

describe('EditarEstatusUsuarioComponent', () => {
  let component: EditarEstatusUsuarioComponent;
  let fixture: ComponentFixture<EditarEstatusUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarEstatusUsuarioComponent]
    });
    fixture = TestBed.createComponent(EditarEstatusUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
