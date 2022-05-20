import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Service} from '../model/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  url = 'http://localhost:8080/api/service';
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

  deleteService(id: number): Observable<Service> {
    return this.http.delete<Service>(`${this.url}/${id}`);
  }
  findByName(serviceName: string) {
    return this.http.get<Service[]>(this.url + '?serviceName_like=' + serviceName );
  }
}
