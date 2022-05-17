import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer';
import {CustomerService} from '../../../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  a: Customer;
  // deleteCustomer: Customer;
  check  = false;
  customerIdDelete: number;
  customerNameDelete: string;
  customerCodeDelete: string;
constructor(private customerService: CustomerService) {
}
  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerList = this.customerService.getAll();
  }

  sendCustomerInfo(customerId: number, customerCode: string, customerName: string) {
    this.customerIdDelete = customerId;
    this.customerCodeDelete = customerCode;
    this.customerNameDelete = customerName;
  }

  deleteCustomer(closeModal: HTMLButtonElement) {
    this.customerService.deleteCustomer(this.customerIdDelete);
    closeModal.click();
    this.getAll();
  }
}
