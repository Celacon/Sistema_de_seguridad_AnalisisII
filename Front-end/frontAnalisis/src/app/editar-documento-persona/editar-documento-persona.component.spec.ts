import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarDocumentoPersonaComponent } from './editar-documento-persona.component';

describe('EditarDocumentoPersonaComponent', () => {
  let component: EditarDocumentoPersonaComponent;
  let fixture: ComponentFixture<EditarDocumentoPersonaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarDocumentoPersonaComponent]
    });
    fixture = TestBed.createComponent(EditarDocumentoPersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
