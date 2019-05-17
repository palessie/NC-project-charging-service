export class Products {
  idProduct: string;
  name: string;
  monthlyPrice: number;
  description: string;

  static cloneBase(product: Products):Products{
    const cloneProducts: Products = new Products();
    cloneProducts.idProduct = product.idProduct;
    cloneProducts.name = product.name;
    cloneProducts.monthlyPrice = product.monthlyPrice;
    cloneProducts.description = product.description;
    return cloneProducts;
}}
