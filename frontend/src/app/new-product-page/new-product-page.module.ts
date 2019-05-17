import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import { FormsModule }   from '@angular/forms';
import { NewProductPageComponent } from './new-product-page.component';
import { CreateProductComponent } from "./create-product/create-product.component";


@NgModule({
  declarations: [
    NewProductPageComponent,
    CreateProductComponent,

  ],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'product/new',
        component: NewProductPageComponent
      }
    ])
  ],

})
export class NewProductPageModule { }
