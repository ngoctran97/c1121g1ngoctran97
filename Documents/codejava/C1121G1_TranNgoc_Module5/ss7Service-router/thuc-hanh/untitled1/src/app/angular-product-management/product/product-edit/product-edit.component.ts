// import { Component, OnInit } from '@angular/core';
// import {FormControl, FormGroup} from '@angular/forms';
// import {ProductService} from '../../service/product.service';
// import {ActivatedRoute, ParamMap} from '@angular/router';
//
// @Component({
//   selector: 'app-product-edit',
//   templateUrl: './product-edit.component.html',
//   styleUrls: ['./product-edit.component.css']
// })
// export class ProductEditComponent implements OnInit {
// productForm: FormGroup;
// id: number;
//   constructor(private productService: ProductService,
//               private activateRoute: ActivatedRoute) {
//     this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
//       this.id = +paramMap.get('id');
//       const product = this.getProduct(this.id);
//       this.productForm = new FormGroup({
//         id: new FormControl(product),
//         name: new FormControl(product),
//         price: new FormControl(product),
//         description: new FormControl(product),
//       });
//     });
//   }
//
//   ngOnInit(): void {
//   }
//
//   private getProduct(id: number) {
//     return this.productService.findById(id);
//
//   }
//
//   updateProduct(id: number) {
//     const product = this.productForm.value;
//     this.productService.updateProduct(id, product);
//     alert( 'ok');
//
//   }
// }


import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  categoryList: Category[] = [];
  compareFn(t1: Category, t2: Category): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit() {
    this.categoryService.getAll().subscribe( data => {
      this.categoryList = data;
    });
  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      console.log(product);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category)
      });
    });
  }

  updateProduct(id: number) {
    const product = this.productForm.value;
    product.category = {
      id: product.category
    };
    this.productService.updateProduct(id, product).subscribe( () => {
      alert('Cập nhật thành công');
      this.router.navigate(['/product/list']);
      }
    );
  }
}
