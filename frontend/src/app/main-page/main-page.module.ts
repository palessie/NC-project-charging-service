import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import { MainPageComponent } from './main-page.component';
import { ProductsComponent } from "./products/products.component";

@NgModule({
  declarations: [
    MainPageComponent,
    ProductsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: '',
        component: MainPageComponent
      }
    ])
  ],

})
export class MainPageModule { }
