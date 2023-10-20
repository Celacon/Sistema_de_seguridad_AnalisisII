import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarAsignarRolesComponent } from './agregar-asignar-roles.component';

describe('AgregarAsignarRolesComponent', () => {
  let component: AgregarAsignarRolesComponent;
  let fixture: ComponentFixture<AgregarAsignarRolesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarAsignarRolesComponent]
    });
    fixture = TestBed.createComponent(AgregarAsignarRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
