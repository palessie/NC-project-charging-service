import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wallet} from "../models/Wallet";
import {WalletOperation} from "../models/walletOperation";

@Injectable()
export class WalletService {

  constructor(private http:HttpClient){

  }

  getAllWallets():Observable<Wallet[]>{
    return this.http.get<Wallet[]>("/api/fwallet");
  }
  getWallet(walletId: string): Observable<Wallet> {
    return this.http.get<Wallet>("/api/fwallet/" + walletId);
  }
  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>("/api/fwallet",wallet)
  }
  deleteWallet(walletId: string): Observable<void> {
    return this.http.delete<void>("/api/fwallet/" + walletId)
  }
  setMoney(wallet: WalletOperation): Observable<void> {
    return this.http.post<void>("api/fwallet/replenish", wallet);
  }



}
