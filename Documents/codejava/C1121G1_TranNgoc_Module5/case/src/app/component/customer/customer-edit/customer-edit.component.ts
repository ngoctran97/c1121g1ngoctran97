import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerForm: FormGroup;
  id: number;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      const customer = this.getCustomer(this.id);
      this.customerForm = new FormGroup({
        id: new FormControl(customer.id),
        customerCode: new FormControl(customer.customerCode),
        customerName: new FormControl(customer.customerName),
        customerDateOfBirth: new FormControl(customer.customerDateOfBirth),
        customerGender: new FormControl(customer.customerGender),
        customerIdCard: new FormControl(customer.customerIdCard),
        customerPhone: new FormControl(customer.customerPhone),
        customerEmail: new FormControl(customer.customerEmail),
        customerAddress: new FormControl(customer.customerAddress),
        customerTypeId: new FormControl(customer.customerTypeId)
      });
    });
  }

  ngOnInit(): void {
  }

  private getCustomer(id: number) {
    return this.customerService.findById(id);
  }

  updateCustomer(id: number) {
    const customer = this.customerForm.value;
    this.customerService.updateCustomer(id, customer);
    this.router.navigate(['/customer']);
    alert('Cập nhật thành công');
  }

}
