import { Component, OnInit } from '@angular/core';
import {BlogService} from '../../service/blog.service';
import {Router} from '@angular/router';
import {Blog} from '../../model/blog';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  blogForm: Blog[] = [];

  constructor(private blogService: BlogService,
              private router: Router) { }

  ngOnInit(): void {
  }

  timkiem() {
    // const blog = this.blogForm.values;
    // this.blogService.saveProduct(blog).subscribe( () => {
    //   this.blogForm.reset();
    //   this.router.navigate(['']);
    // }, e => {
    //   console.log(e);
    // });
  }
}
