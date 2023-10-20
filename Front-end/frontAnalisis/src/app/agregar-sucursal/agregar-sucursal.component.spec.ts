import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarSucursalComponent } from './agregar-sucursal.component';

describe('AgregarSucursalComponent', () => {
  let component: AgregarSucursalComponent;
  let fixture: ComponentFixture<AgregarSucursalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarSucursalComponent]
    });
    fixture = TestBed.createComponent(AgregarSucursalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
