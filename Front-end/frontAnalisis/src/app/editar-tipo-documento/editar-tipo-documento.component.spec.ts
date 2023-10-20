import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarTipoDocumentoComponent } from './editar-tipo-documento.component';

describe('EditarTipoDocumentoComponent', () => {
  let component: EditarTipoDocumentoComponent;
  let fixture: ComponentFixture<EditarTipoDocumentoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarTipoDocumentoComponent]
    });
    fixture = TestBed.createComponent(EditarTipoDocumentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
