import {Users} from "./Users";
import {Products} from "./products";

export class Subscriptions {
  idSubscription : string;
  user : Users;
  product: Products;
  startDate : string;
  endDate : string;
  duration : number;
  cost:number;

  static cloneBase(subscription: Subscriptions ):Subscriptions{
    const cloneSubscriptions: Subscriptions = new Subscriptions();
    cloneSubscriptions.idSubscription = subscription.idSubscription;
    cloneSubscriptions.user = subscription.user;
    cloneSubscriptions.product = subscription.product;
    cloneSubscriptions.startDate = subscription.startDate;
    cloneSubscriptions.endDate = subscription.endDate;
    cloneSubscriptions.duration = subscription.duration;
    cloneSubscriptions.cost=subscription.cost;
    return cloneSubscriptions;
  }
}
