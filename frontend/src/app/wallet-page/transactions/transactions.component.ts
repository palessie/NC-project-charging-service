import {Component, OnDestroy, OnInit} from '@angular/core';
import {Transactions} from "../../models/Transactions";
import {Subscriptions} from "../../models/Subscriptions";
import {TransactionsService} from "../../service/transactions.service";
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit,OnDestroy {

  public transactions: Transactions[];
  public chargeTransactions: Transactions[] = [];
  public refillTransactions: Transactions[] = [];
  private subscriptions: Subscriptions[] = [];
  public currentType = 'ALL';
  public handler: boolean = true;

  constructor(private transactionService: TransactionsService, private authService: AuthService,
               private router: Router,
              ) { }

  ngOnInit() {
  }

  ngOnDestroy() {

  }

 /* loadTransactions(login: string) {
    this.subscriptions.push(this.transactionService.getTransactionsByLogin(login).subscribe(actions => {
      this.transactions = actions as Transactions[];
      for(let action of actions) {
        if(action.action == "MINUS")
          this.chargeTransactions.push(action);
        else
          this.refillTransactions.push(action);
      }

    }))
  }*/

  public _subDate(date: string): string {
    return date.substring(0, 10);
  }

  public setType(type: string): void {
    this.currentType = type;
  }
}
