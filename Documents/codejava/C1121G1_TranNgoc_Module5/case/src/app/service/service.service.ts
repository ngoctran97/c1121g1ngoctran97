import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Service} from '../model/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  url = 'http://localhost:3000/service';
  serviceList: Service[] = [];
  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  saveService(service) {
    return this.http.post(this.url, service);
  }

  findById(id: number): Observable<Service> {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  updateService(id: number, service: Service): Observable<Service> {
    return this.http.put<Service>(`${this.url}/${id}`, service);
  }


  deleteService(serviceId: number) {
    this.serviceList = this.serviceList.filter(service => {
      return service.id !== serviceId;
    });
  }
}
