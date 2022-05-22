import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HuongComponent } from './huong.component';

describe('HuongComponent', () => {
  let component: HuongComponent;
  let fixture: ComponentFixture<HuongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HuongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HuongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
