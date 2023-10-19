import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarBancoComponent } from './editar-banco.component';

describe('EditarBancoComponent', () => {
  let component: EditarBancoComponent;
  let fixture: ComponentFixture<EditarBancoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditarBancoComponent]
    });
    fixture = TestBed.createComponent(EditarBancoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
