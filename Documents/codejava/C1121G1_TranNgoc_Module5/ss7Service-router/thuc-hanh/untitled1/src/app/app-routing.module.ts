// import {NgModule} from '@angular/core';
// import {RouterModule, Routes} from '@angular/router';
// import {YoutubePlaylistComponent} from './angular-youtobe-management/youtube-playlist/youtube-playlist.component';
// import {YoutubePlayerComponent} from './angular-youtobe-management/youtube-player/youtube-player.component';
//
//
// const routes: Routes = [
//   {
//     path: 'youtube',
//     component: YoutubePlaylistComponent,
//     children: [{
//       path: ':id',
//       component: YoutubePlayerComponent
//     }]
//   }
// ];
//
// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule {
// }



// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
// import {ProductListComponent} from './product/product-list/product-list.component';
//
//
// const routes: Routes = [{
//   path: 'product/list',
//   component: ProductListComponent
// }];
//
// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }


// product

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './angular-product-management/product/product-list/product-list.component';
import {ProductCreateComponent} from './angular-product-management/product/product-create/product-create.component';
import {ProductEditComponent} from './angular-product-management/product/product-edit/product-edit.component';
import {ProductDeleteComponent} from './angular-product-management/product/product-delete/product-delete.component';
import {CategoryListComponent} from './angular-product-management/category/category-list/category-list.component';
import {CategoryCreateComponent} from './angular-product-management/category/category-create/category-create.component';
import {CategoryEditComponent} from './angular-product-management/category/category-edit/category-edit.component';
import {CategoryDeleteComponent} from './angular-product-management/category/category-delete/category-delete.component';
import {AngularProductManagementModule} from './angular-product-management/angular-product-management.module';

const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forRoot(routes), AngularProductManagementModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
