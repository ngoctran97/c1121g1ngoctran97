import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceCreateHouseComponent } from './service-create-house.component';

describe('ServiceCreateHouseComponent', () => {
  let component: ServiceCreateHouseComponent;
  let fixture: ComponentFixture<ServiceCreateHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceCreateHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceCreateHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
