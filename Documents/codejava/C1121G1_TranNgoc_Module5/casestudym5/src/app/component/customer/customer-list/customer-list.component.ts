import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer';
import {CustomerService} from '../../../service/customer.service';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  a: Customer;
  check  = false;
  customerIdDelete: number;
  customerNameDelete: string;
  customerCodeDelete: string;
  p = 1;
constructor(private customerService: CustomerService) {
}
  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe( data => {
      this.customerList = data;
      console.log(data);
    });
  }

  sendCustomerInfo(customerId: number, customerCode: string, customerName: string) {
    this.customerIdDelete = customerId;
    this.customerCodeDelete = customerCode;
    this.customerNameDelete = customerName;
  }

  deleteCustomer(closeModal: HTMLButtonElement) {
    this.customerService.deleteCustomer(this.customerIdDelete).subscribe( () => {
      closeModal.click();
      this.getAll();
    });
  }

  search(customerName: string, customerCode: string) {
    this.customerService.findByName(customerName, customerCode).subscribe( data => {
      this.customerList = data;
      console.log(data);
    });
  }
}


