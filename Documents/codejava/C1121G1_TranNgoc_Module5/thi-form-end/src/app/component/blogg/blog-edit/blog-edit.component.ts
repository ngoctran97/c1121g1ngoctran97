import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BlogService} from '../../../service/blog.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-blog-edit',
  templateUrl: './blog-edit.component.html',
  styleUrls: ['./blog-edit.component.css']
})
export class BlogEditComponent implements OnInit {
  blogForm: FormGroup;
  id: number;
  constructor(private blogService: BlogService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getBlog(this.id);
    });
  }

  ngOnInit(): void {
  }

  private getBlog(id: number) {
    return this.blogService.findById(id).subscribe( blog => {
      console.log(blog);
      this.blogForm = new FormGroup({
        id:  new FormControl(blog.id),
        danhMuc:  new FormControl(blog.danhMuc),
        vungMien:  new FormControl(blog.vungMien),
        banla:  new FormControl(blog.banla),
        dangTin:  new FormControl(blog.dangTin),
        tinhTrang: new FormControl(blog.tinhTrang),
        diaChi:  new FormControl(blog.diaChi),
        dienTich: new FormControl(blog.dienTich),
        huong:  new FormControl(blog.huong),
        tuaDe:  new FormControl(blog.tuaDe),
        noiDunh:  new FormControl(blog.noiDunh),
        gia: new FormControl(blog.gia),
        trangThai: new FormControl(blog.trangThai),
        ngayDang: new FormControl(blog.ngayDang)
      });
    });
  }

  updateProduct(id: number) {
    const blog = this.blogForm.value;
    this.blogService.updateBlog(id, blog).subscribe( () => {
        alert('Chỉnh sửa thành công');
        this.router.navigate(['']);
      }, err => {
        console.log(err);
      }
    );
  }
}
