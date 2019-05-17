import { Component, OnInit } from '@angular/core';
import {Subscriptions} from "../../models/Subscriptions";
import {Subscription} from "rxjs";

import {SubscribeCondition} from "../../models/subscribeCondition";
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";
import {SubscriptionsService} from "../../service/subscriptions.service";
import {SubscriptionChange} from "../../models/subscriptionChange";
import {LoginEventService} from "../../service/login-event.service";
import {AdminUserService} from "../../service/admin-user.service";

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {

  public subscription: Subscriptions[];
  private subscriptions: Subscription[] = [];
  private username: string;
  public handler: boolean = true;
  public resultCondition: SubscribeCondition;
  private currentId: string;

  constructor(private subscriptionService: SubscriptionsService,
              private authService: AuthService, private router: Router,
              private loginEventService: LoginEventService, private adminUserService: AdminUserService,) {
  }

  ngOnInit() {
    this.checkUsername();
    this.loginEventService.skipClicked.subscribe(value => {
      if (value == true) {
        this.router.navigate(['']);
      }
    })
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

 /* private loadProducts(login: string): void {

    this.subscriptions.push(this.subscriptionService.getSubscriptionsByLogin(login).subscribe(subs => {
      this.subscription = subs as Subscriptions[];

    }))
  }*/

  public cancelSubscription(subscriptionId: string): void {
    this.subscriptions.push(this.subscriptionService.deleteSubscription(subscriptionId).subscribe(() => {
      this.updateSubscriptions();
    }))
  }

  private updateSubscriptions(): void {
  //  this.loadProducts(this.authService.getUsername());
  }

  private checkUsername(): void {
    if (this.authService.getRole() == "ADMIN") {
      this.handler = false;
      this.adminUserService.getLogin().subscribe(login => {
        this.username = login;
      });
    } else if (this.authService.getRole() == "USER")
      this.username = this.authService.getUsername();
    else
      this.router.navigate(['']);

 //   this.loadProducts(this.username);
  }

  public _computePrice(duration, discount, price): void {
    let currentCondition = new SubscribeCondition();
    currentCondition.price = price;
    currentCondition.duration = duration;
    this.subscriptions.push(this.subscriptionService.computePrice(currentCondition).subscribe(result => {
      this.resultCondition = result as SubscribeCondition;
    }))
  }

  public extendSubscriptions(condition: SubscribeCondition): void {
    let renewal: SubscriptionChange = new SubscriptionChange();
    renewal.id = this.currentId;
    renewal.cost = condition.price;
    renewal.duration = condition.duration;
    this.subscriptions.push(this.subscriptionService.extendSubscription(renewal).subscribe(() => {
  //    this.loadProducts(this.authService.getUsername());
    }))
  }
}
