import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelinesComponent } from './angular-timelines-app/timelines/timelines.component';
import { YoutubePlaylistComponent } from './angular-youtobe-management/youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './angular-youtobe-management/youtube-player/youtube-player.component';
import { ProductListComponent } from './angular-product-management/product/product-list/product-list.component';
import { ProductCreateComponent } from './angular-product-management/product/product-create/product-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ProductEditComponent } from './angular-product-management/product/product-edit/product-edit.component';
import { ProductDeleteComponent } from './angular-product-management/product/product-delete/product-delete.component';
import {SharedModule} from './angular-product-management/shared/shared.module';
import {HttpClientModule} from '@angular/common/http';
import { CategoryListComponent } from './angular-product-management/category/category-list/category-list.component';
import { CategoryCreateComponent } from './angular-product-management/category/category-create/category-create.component';
import { CategoryEditComponent } from './angular-product-management/category/category-edit/category-edit.component';
import { CategoryDeleteComponent } from './angular-product-management/category/category-delete/category-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ProductDeleteComponent,
    CategoryListComponent,
    CategoryCreateComponent,
    CategoryEditComponent,
    CategoryDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
