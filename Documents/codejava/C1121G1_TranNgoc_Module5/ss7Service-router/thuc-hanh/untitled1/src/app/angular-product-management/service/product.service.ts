import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url = 'http://localhost:3000/product';
  products: Product[] = [];


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  saveProduct(product) {
    return this.http.post(this.url, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.url}/${id}`, product);
  }
  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`${this.url}/${id}`);
  }
}
