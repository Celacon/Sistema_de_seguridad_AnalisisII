import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAsignarRolesComponent } from './editar-asignar-roles.component';

describe('EditarAsignarRolesComponent', () => {
  let component: EditarAsignarRolesComponent;
  let fixture: ComponentFixture<EditarAsignarRolesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarAsignarRolesComponent]
    });
    fixture = TestBed.createComponent(EditarAsignarRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
