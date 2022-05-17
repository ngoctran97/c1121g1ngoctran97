import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  serviceForm: FormGroup;
  constructor() {
    this.serviceForm = new FormGroup( {
      serviceCode: new FormControl( '', [Validators.required, Validators.pattern( '^$|(DV-)[0-9]{4}')]),
      serviceName: new FormControl( '', Validators.required),
      serviceArea: new FormControl( '', [Validators.required, Validators.min(0)]),
      serviceCost: new FormControl( '', [Validators.required, Validators.min(0)]),
      serviceMaxPeople: new FormControl( '', [Validators.required, Validators.min(0)]),
      standardRoom: new FormControl( '', Validators.required),
      descritionOtherConvenience: new FormControl( '', Validators.required),
      numberOdFloors: new FormControl( '', Validators.required),
      rentType: new FormControl( '', Validators.required),
    });
  }


  ngOnInit(): void {
  }

  submitService() {
    console.log(this.serviceForm);
  }
}
