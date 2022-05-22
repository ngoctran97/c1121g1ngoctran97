import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BlogService} from '../../../service/blog.service';
import {Router} from '@angular/router';
import {DanhMuc} from '../../../model/danhMuc';
import {DangTin} from '../../../model/dangTin';
import {Huong} from '../../../model/huong';
import {VungMien} from '../../../model/vungMien';

@Component({
  selector: 'app-blog-create',
  templateUrl: './blog-create.component.html',
  styleUrls: ['./blog-create.component.css']
})
export class BlogCreateComponent implements OnInit {
  blogForm: FormGroup = new FormGroup( {
    id:  new FormControl('', Validators.required),
    danhMucDto:  new FormControl('', Validators.required),
    vungMienDto:  new FormControl('', Validators.required),
    banla:  new FormControl('', Validators.required),
    dangTinDto:  new FormControl('', Validators.required),
    tinhTrang:  new FormControl('', Validators.required),
    diaChi:  new FormControl('', Validators.required),
    dienTich: new FormControl( '', [Validators.required, Validators.min(20)]),
    huongDto:  new FormControl('', Validators.required),
    tuaDe:  new FormControl('', Validators.required),
    noiDunh:  new FormControl('', Validators.required),
    gia: new FormControl( '', [Validators.required, Validators.min(100000000)]),
    trangThai: new FormControl('', Validators.required),
    ngayDang: new FormControl('', Validators.required)
  });
  successBtn: HTMLButtonElement;
  errorBtn: HTMLButtonElement;
  danhMucList: DanhMuc[] = [];
  dangTinList: DangTin[] = [];
  huongList: Huong[] = [];
  vungMienList: VungMien[] = [];
  constructor(private blogService: BlogService,
              private router: Router) { }
  ngOnInit(): void {
  }

  submitblog(successBtn: HTMLButtonElement, errorBtn: HTMLButtonElement) {
    // const blog = this.blogForm.value;
    // this.blogService.saveBlog(blog).subscribe( () => {
    //   this.blogForm.reset();
    //   this.router.navigate(['']);
    // }, e => {
    //   console.log(e);
    // });
    if (this.blogForm.valid){
      this.blogService = this.blogForm.value;
      this.blogService.saveBlog(this.blogService).subscribe(() => {
        successBtn.click();
      });
    }else {
      errorBtn.click();
    }
  }
}
