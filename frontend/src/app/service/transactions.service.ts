import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Transactions} from "../models/Transactions";

@Injectable()
export class TransactionsService {

  constructor(private http:HttpClient){

  }

  getAllTransactions():Observable<Transactions[]>{
    return this.http.get<Transactions[]>("/api/ftransactions");
  }
  getTransaction(transactionId: string): Observable<Transactions> {
    return this.http.get<Transactions>("/api/ftransactions/" + transactionId);
  }
  saveTransaction(transaction: Transactions): Observable<Transactions> {
    return this.http.post<Transactions>("/api/ftransactions", transaction)
  }
  deleteTransaction(transactionId: string): Observable<void> {
    return this.http.delete<void>("/api/ftransactions/" + transactionId)
  }



}
