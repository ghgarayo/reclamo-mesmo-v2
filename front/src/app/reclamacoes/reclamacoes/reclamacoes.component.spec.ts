import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReclamacoesComponent } from './reclamacoes.component';

describe('ReclamacoesComponent', () => {
  let component: ReclamacoesComponent;
  let fixture: ComponentFixture<ReclamacoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReclamacoesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReclamacoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
