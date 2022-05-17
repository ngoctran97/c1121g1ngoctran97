import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customerList: Customer[] = [{
    id: 1, customerCode: 'KH-0001',
    customerName: 'Ngọc Trần',
    customerDateOfBirth: '27/06/1996',
    customerGender: 'Nữ',
    customerIdCard: 123456789,
    customerPhone: '0987654321',
    customerEmail: 'ngoctran@gmail.com',
    customerAddress: 'Thừa Thiên Huế',
    customerTypeId: 'Diamond'
  }, {
    id: 2,
    customerCode: 'KH-0002',
    customerName: 'Trong Trần',
    customerDateOfBirth: '27/06/1996',
    customerGender: 'Nam',
    customerIdCard: 123456789,
    customerPhone: '0987654321',
    customerEmail: 'trongtran@gmail.com',
    customerAddress: 'Thừa Thiên Huế',
    customerTypeId: 'Diamond'
  }];

  constructor() {
  }

  getAll() {
    return this.customerList;
  }

  saveCustomer(customer) {
    this.customerList.push(customer);
  }

  findById(id: number) {
    return this.customerList.find(customer => customer.id === id);
  }

  updateCustomer(id: number, customer: Customer) {
    for (let i = 0; i < this.customerList.length; i++) {
      if (this.customerList[i].id === id) {
        this.customerList[i] = customer;
      }
    }
  }

  deleteCustomer(customeerId: number){
    this.customerList = this.customerList.filter(customer => {
      return customer.id !== customeerId;
    });
  }

}
