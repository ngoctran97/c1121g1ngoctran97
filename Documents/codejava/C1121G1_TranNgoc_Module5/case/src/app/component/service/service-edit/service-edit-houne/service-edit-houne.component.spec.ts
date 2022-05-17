import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceEditHouneComponent } from './service-edit-houne.component';

describe('ServiceEditHouneComponent', () => {
  let component: ServiceEditHouneComponent;
  let fixture: ComponentFixture<ServiceEditHouneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceEditHouneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceEditHouneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
