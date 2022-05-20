import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceEditVillaComponent } from './service-edit-villa.component';

describe('ServiceEditVillaComponent', () => {
  let component: ServiceEditVillaComponent;
  let fixture: ComponentFixture<ServiceEditVillaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceEditVillaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceEditVillaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
