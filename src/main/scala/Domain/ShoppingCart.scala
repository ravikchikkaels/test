package Domain



/**
  * Created by CHIKKAR on 19/07/2017.
  */
class ShoppingCart{
  private var lstProducts = List[CartProduct]()

  def AddProduct(p : Domain.Product): Unit ={
    lstProducts = new CartProduct(p,lstProducts.length + 1,  CurrentOffers.getOfferByProduct(p)) :: lstProducts
  }

  def getAllProducts() : List[CartProduct] = {
    lstProducts
  }
}
