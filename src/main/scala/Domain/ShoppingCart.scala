package Domain



/**
  * Created by CHIKKAR on 19/07/2017.
  */
class ShoppingCart{
  private var lstProducts = List[CartProduct]()

  def AddProduct(p : Domain.Product): Unit ={
    val chkOffer = CurrentOffers.getOfferByProduct(p) match {
      case None => OfferType.None
      case Some(x) => x.offerType
    }

    lstProducts = new CartProduct(p,lstProducts.length + 1,  chkOffer) :: lstProducts
  }

  def getAllProducts() : List[CartProduct] = {
    lstProducts
  }
}
