import {Subscriptions} from "./Subscriptions";
import {Wallet} from "./Wallet";

export class Transactions {
  idTransaction : string;
  money : number;
  wallet : Wallet;
  date : string;
  subscription : Subscriptions;
  action:string;


  static cloneBase(transactions: Transactions ):Transactions{
    const cloneTransactions: Transactions = new Transactions();
    cloneTransactions.subscription = transactions.subscription;
    cloneTransactions.money = transactions.money;
    cloneTransactions.wallet = transactions.wallet;
    cloneTransactions.date  = transactions.date ;
    cloneTransactions.idTransaction = transactions.idTransaction;
    cloneTransactions.action = transactions.action;
    return cloneTransactions;
  }
}
