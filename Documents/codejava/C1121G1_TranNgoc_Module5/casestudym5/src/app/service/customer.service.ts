import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';
import {Observable} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Service} from '../model/service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url = 'http://localhost:8080/api/customer';
  customerList: Customer[] = [];

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  saveCustomer(customer) {
    return this.http.post(this.url, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.url}/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.url}/${id}`);
  }

  findByName(customerName: string, customerCode: string) {
    return this.http.get<any>(`${this.url}?customerName_like=${customerName} &customerCode_like=${customerCode}` );
  }
}
