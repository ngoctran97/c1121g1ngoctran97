import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DangTinComponent } from './dang-tin.component';

describe('DangTinComponent', () => {
  let component: DangTinComponent;
  let fixture: ComponentFixture<DangTinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DangTinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DangTinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
