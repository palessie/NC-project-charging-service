import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Products} from "../models/products";

@Injectable()
export class ProductsService {

  constructor(private http:HttpClient){

  }

  getAllProducts():Observable<Products[]>{
    return this.http.get<Products[]>('/api/fproducts');
  }
  getProduct(productId: string): Observable<Products> {
    return this.http.get<Products>("/api/fproducts/" + productId);
  }
  saveProduct(product: Products): Observable<Products> {
    return this.http.post<Products>("/api/fproducts", product)
  }
  deleteProduct(productId: string): Observable<void> {
      return this.http.delete<void>("/api/fproducts/" + productId)
  }

  getPostsByPage(page: number, quantity: number): Observable<Products[]> {
    return this.http.get<Products[]>('/api/fproducts/page/' + page + "?qt=" + quantity);
  }

  getTotalPages(quantity: number): Observable<number> {
    return this.http.get<number>('api/fproducts/total-pages?qt=' + quantity);
  }


}
