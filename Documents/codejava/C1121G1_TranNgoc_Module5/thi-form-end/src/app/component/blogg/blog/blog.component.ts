import { Component, OnInit } from '@angular/core';
import {Blog} from '../../../model/blog';
import {BlogService} from '../../../service/blog.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  blogList: Blog[] = [];
  p: number;
  id: number;
  tuaDe: string;

  constructor(private blogService: BlogService) { }

  ngOnInit(): void {
    this.blogService.getAll(0).subscribe( data => {
      this.blogList = data.content;
      console.log(data);
    });
  }


  search(huong: string, dienTich: string, gia: string) {
    this.blogService.findByName(huong, dienTich, gia).subscribe( data => {
      this.blogList = data;
      console.log(data);
    });
  }

  sendBlog(id: number, tuaDe: string) {
    this.id = id;
    this.tuaDe = tuaDe;
  }

  delete(closeModal: HTMLButtonElement) {
    this.blogService.delete(this.id).subscribe( () => {
      closeModal.click();
      this.ngOnInit();
    });
  }
}
