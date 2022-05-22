import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Blog} from '../model/blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
// url = 'http://localhost:3000/blog';
  url = 'http://localhost:8080/api/blog';
  constructor(private http: HttpClient) {
  }

  getAll(page: number): Observable<any> {
    return this.http.get<any>(`${this.url}?page=${page}`);
  }

  saveBlog(blog: any) {
    return this.http.post(this.url, blog);
  }

  findByName(huong: string, dienTich: string, gia: string) {
    return this.http.get<any>(`${this.url}?huong_like=${huong}&dienTich_like=${dienTich}&gia_like=${gia}` );
  }
  delete(id: number): Observable<Blog> {
    return this.http.delete<Blog>(`${this.url}/${id}`);
  }

  findById(id: number): Observable<Blog> {
    return this.http.get<any>(`${this.url}/${id}`);
  }
  updateBlog(id: number, blog: Blog): Observable<Blog> {
    return this.http.put<Blog>(`${this.url}/${id}`, blog);
  }
}
