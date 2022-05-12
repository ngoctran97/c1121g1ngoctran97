import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup;

  constructor() {
    this.customerForm = new FormGroup( {
      customerCode: new FormControl( '', [Validators.required, Validators.pattern( '^$|(KH-)[0-9]{4}')]),
      customerName: new FormControl( '', Validators.required),
      customerDateOfBirth: new FormControl( '', Validators.required),
      customerGender: new FormControl( '', Validators.required),
      customerIdCard: new FormControl( '', [Validators.required]),
      customerPhone:  new FormControl( '', [Validators.required, Validators.pattern( '^\\+84\\d{9,10}$')]),
      customerEmail: new FormControl( '', [Validators.required, Validators.email]),
      customerAddress: new FormControl( '', Validators.required),
      customerTypeId: new FormControl( '', Validators.required),
    });
  }

  ngOnInit(): void {
  }
  submitCustomer(){
    console.log(this.customerForm);
  }
}
