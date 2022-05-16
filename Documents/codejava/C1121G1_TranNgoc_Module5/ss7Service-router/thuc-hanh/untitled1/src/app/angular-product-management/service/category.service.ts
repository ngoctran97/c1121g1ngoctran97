import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  url = 'http://localhost:3000/category';
  categoryList: Category[] = [];

  constructor(private http: HttpClient) { }
  getAll(): Observable<any>{
    return this.http.get<any>(this.url);
  }

  saveCategory(category) {
    return this.http.post(this.url, category);
  }
  findById(id: number): Observable<Category> {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    return this.http.put<Category>(`${this.url}/${id}`, category);
  }

  deleteCategory(id: number): Observable<Category> {
    return this.http.delete<Category>(`${this.url}/${id}`);
  }
}
