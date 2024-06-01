import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfertantesPanelComponent } from './ofertantes-panel.component';

describe('OfertantesPanelComponent', () => {
  let component: OfertantesPanelComponent;
  let fixture: ComponentFixture<OfertantesPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OfertantesPanelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OfertantesPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
