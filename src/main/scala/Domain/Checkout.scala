package Domain

import Domain.OfferType.OfferType

/**
  * Created by CHIKKAR on 19/07/2017.
  */



object Checkout {
  def getCheckoutTotal(cart: ShoppingCart): Double = {
    val cproducts = cart.getAllProducts().groupBy(x => x.product.name).map(x => {
      val offer = x._2.head.offer.get
      (x._1, offer.getPrice(x._2))
    })

    cproducts.foldLeft(0.0)(_ + _._2)
  }
}
