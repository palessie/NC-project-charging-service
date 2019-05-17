import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import {SubscriptionsPageComponent } from './subscriptions-page.component';
import { SubscriptionsComponent } from "./subscriptions/subscriptions.component";


@NgModule({
  declarations: [
    SubscriptionsPageComponent,
    SubscriptionsComponent,

  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'subscriptions',
        component: SubscriptionsPageComponent
      }
    ])
  ],

})
export class SubscriptionsPageModule { }
