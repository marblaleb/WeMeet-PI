import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForoDetalleComponent } from './foro-detalle.component';

describe('ForoDetalleComponent', () => {
  let component: ForoDetalleComponent;
  let fixture: ComponentFixture<ForoDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ForoDetalleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ForoDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
