import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarPuestoComponent } from './editar-puesto.component';

describe('EditarPuestoComponent', () => {
  let component: EditarPuestoComponent;
  let fixture: ComponentFixture<EditarPuestoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarPuestoComponent]
    });
    fixture = TestBed.createComponent(EditarPuestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
