import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import { ProductPageComponent } from './product-page.component';
import { ProductComponent } from "./product/product.component";
import { SubscribeComponent } from './subscribe/subscribe.component';


@NgModule({
  declarations: [
    ProductPageComponent,
    ProductComponent,
    SubscribeComponent,

  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'product',
        component: ProductPageComponent
      }
    ])
  ],

})
export class ProductPageModule { }
