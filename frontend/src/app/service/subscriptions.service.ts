import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subscriptions} from "../models/Subscriptions";
import {SubscribeCondition} from "../models/subscribeCondition";
import {SubscriptionChange} from "../models/subscriptionChange";
import {StringResponse} from "../models/stringResponse";

@Injectable()
export class SubscriptionsService {

  constructor(private http:HttpClient){

  }

  getAllSubscriptions():Observable<Subscriptions[]>{
    return this.http.get<Subscriptions[]>("/api/fsubscriptions");
  }
  getSubscription(subscriptionId: string): Observable<Subscriptions> {
    return this.http.get<Subscriptions>("/api/fsubscriptions/" + subscriptionId);
  }
  saveSubscription(subscription: Subscriptions): Observable<StringResponse> {
    return this.http.post<StringResponse>("/api/fsubscriptions", subscription)
  }
  deleteSubscription(subscriptionId: string): Observable<void> {
    return this.http.delete<void>("/api/fsubscriptions/" + subscriptionId)
  }
  computePrice(condition: SubscribeCondition): Observable<SubscribeCondition> {
    return this.http.post<SubscribeCondition>("api/fsubscriptions/compute", condition);
  }

  extendSubscription(sub: SubscriptionChange): Observable<void> {
    return this.http.post<void>("api/fsubscriptions/extend", sub);
  }

  chargeMoney(): Observable<void> {
    return this.http.post<void>("api/fsubscriptions/charge", null);
  }
  getSubscriptionsByLogin(login:String):Observable<Subscriptions>{
  return this.http.get<Subscriptions>("/api/fsubscriptions/ulogin" + login);
  }


}
