import { Component, OnInit } from '@angular/core';
import {Wallet} from "../../models/Wallet";
import {WalletService} from "../../service/wallet.service";
import {Subscription} from "rxjs/internal/Subscription";
import {WalletOperation} from "../../models/walletOperation";
import {Transactions} from "../../models/Transactions";
import {Router} from "@angular/router";
import {TransactionsService} from "../../service/transactions.service";
import {UsersService} from "../../service/users.service";
import {AuthService} from "../../service/auth.service";
import {LoginEventService} from "../../service/login-event.service";


@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

  public wallet: Wallet;
  public  amount: number;
  private subscriptions: Subscription[] = [];
  private transaction: Transactions = new Transactions();
  private username: string;
  public handler: boolean = true;

  constructor(private transactionsService: TransactionsService, private usersService: UsersService,
              private authService: AuthService, private walletService: WalletService,
               private loginEventService: LoginEventService,
              private router: Router) { }

  ngOnInit() {

    if(this.authService.getUsername() != null) {
      if(this.authService.getRole() == "ADMIN") {
        this.handler = false;
      }
    }
    else
      this.router.navigate(['']);

    this.loadWallet(this.authService.getUsername());
    this.loginEventService.skipClicked.subscribe( value => {
      if(value == true) {
        this.router.navigate(['']);
      }
    });
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe())
  }

  private loadWallet(login: string) {
    this.subscriptions.push(this.usersService.getUserByLogin(login).subscribe(account => {
      this.wallet = account.wallet as Wallet;
      console.log("Wallet: " + this.wallet.amountOfMoney);
    }));
  }
  private updateWallet(): void {
    this.loadWallet(this.authService.getUsername());
  }

  private createTransaction(): Transactions {

    this.transaction.money = this.amount;
    this.transaction.action = "PLUS";
    this.transaction.wallet = this.wallet;
    return this.transaction;
  }

  public _replenishBalance(idWallet: string): void {

    let operation: WalletOperation = new WalletOperation();

    operation.amount = +this.amount;
    operation.id = idWallet;

    this.subscriptions.push(this.walletService.setMoney(operation).subscribe(result => {
      console.log(result);
    }));

    this.subscriptions.push(this.transactionsService.saveTransaction(this.createTransaction()).subscribe(() => {

      console.log("Fill up")
      this.updateWallet();
    }));

  }


}
