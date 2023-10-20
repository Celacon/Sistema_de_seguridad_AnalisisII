import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarRoleComponent } from './agregar-role.component';

describe('AgregarRoleComponent', () => {
  let component: AgregarRoleComponent;
  let fixture: ComponentFixture<AgregarRoleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarRoleComponent]
    });
    fixture = TestBed.createComponent(AgregarRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
