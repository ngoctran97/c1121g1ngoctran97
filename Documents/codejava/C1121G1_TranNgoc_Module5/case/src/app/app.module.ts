import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { ServiceListComponent } from './component/service/service-list/service-list.component';
import { ServiceEditVillaComponent } from './component/service/service-edit/service-edit-villa/service-edit-villa.component';
import { ServiceCreateVillaComponent } from './component/service/service-create/service-create-villa/service-create-villa.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { ContractCreateComponent } from './component/contract/contract-create/contract-create.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import { ServiceEditHouneComponent } from './component/service/service-edit/service-edit-houne/service-edit-houne.component';
import { ServiceCreateComponent } from './component/service/service-create/service-create-houne/service-create.component';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    ServiceListComponent,
    ServiceEditVillaComponent,
    ServiceCreateVillaComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
    ContractCreateComponent,
    ContractListComponent,
    ServiceEditHouneComponent,
    ServiceCreateComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      ReactiveFormsModule,
      HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
