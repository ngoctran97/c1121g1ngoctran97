import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {BlogComponent} from './component/blogg/blog/blog.component';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import { BlogCreateComponent } from './component/blogg/blog-create/blog-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { SearchComponent } from './component/search/search.component';
import { BlogEditComponent } from './component/blogg/blog-edit/blog-edit.component';
import { DangTinComponent } from './component/dang-tin/dang-tin.component';
import { DanhMucComponent } from './component/danh-muc/danh-muc.component';
import { HuongComponent } from './component/huong/huong.component';
import { VungMienComponent } from './component/vung-mien/vung-mien.component';



@NgModule({
  declarations: [
    AppComponent,
    BlogComponent,
    BlogCreateComponent,
    SearchComponent,
    BlogEditComponent,
    DangTinComponent,
    DanhMucComponent,
    HuongComponent,
    VungMienComponent
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
