import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarDocumentoPersonaComponent } from './agregar-documento-persona.component';

describe('AgregarDocumentoPersonaComponent', () => {
  let component: AgregarDocumentoPersonaComponent;
  let fixture: ComponentFixture<AgregarDocumentoPersonaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarDocumentoPersonaComponent]
    });
    fixture = TestBed.createComponent(AgregarDocumentoPersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
