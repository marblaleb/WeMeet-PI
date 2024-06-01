import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginOfertanteComponent } from './login-ofertante.component';

describe('LoginOfertanteComponent', () => {
  let component: LoginOfertanteComponent;
  let fixture: ComponentFixture<LoginOfertanteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginOfertanteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LoginOfertanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
