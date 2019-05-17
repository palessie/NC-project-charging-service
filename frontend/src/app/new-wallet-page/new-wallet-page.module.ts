import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import { NewWalletPageComponent } from './new-wallet-page.component';
import { CreateWalletComponent } from "./create-wallet/create-wallet.component";


@NgModule({
  declarations: [
    NewWalletPageComponent,
    CreateWalletComponent,

  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'wallet/new',
        component: NewWalletPageComponent
      }
    ])
  ],

})
export class NewWalletPageModule { }
