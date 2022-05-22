import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VungMienComponent } from './vung-mien.component';

describe('VungMienComponent', () => {
  let component: VungMienComponent;
  let fixture: ComponentFixture<VungMienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VungMienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VungMienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
