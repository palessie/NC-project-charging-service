import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import { WalletPageComponent } from './wallet-page.component';
import { WalletComponent } from "./wallet/wallet.component";
import { TransactionsComponent } from "./transactions/transactions.component";

@NgModule({
  declarations: [
    WalletPageComponent,
    WalletComponent,
    TransactionsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'wallet',
        component: WalletPageComponent
      }
    ])
  ],

})
export class WalletPageModule { }
