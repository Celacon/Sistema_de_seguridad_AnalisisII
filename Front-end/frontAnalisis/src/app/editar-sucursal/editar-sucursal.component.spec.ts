import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarSucursalComponent } from './editar-sucursal.component';

describe('EditarSucursalComponent', () => {
  let component: EditarSucursalComponent;
  let fixture: ComponentFixture<EditarSucursalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarSucursalComponent]
    });
    fixture = TestBed.createComponent(EditarSucursalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
