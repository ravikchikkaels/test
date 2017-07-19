package Domain

import Domain.OfferType.OfferType

/**
  * Created by CHIKKAR on 19/07/2017.
  */
abstract class priceCalculator[T]
{
  def calculate(cart: List[CartProduct]):Double
}

class BuyOneGetOneFree extends priceCalculator
{
  override def calculate(cart: List[CartProduct]): Double = {
    val otype = cart.head.offerType
    val productPrice = cart.head.product.price
    (cart.length / 2) * productPrice +  (cart.length % 2) * productPrice
  }
}



object Checkout {
  def getCheckoutTotal(cart: ShoppingCart): Double = {
    val cproducts = cart.getAllProducts().groupBy(x => x.product.name).map(x => (x._1, getDiscountTotal(x._2.iterator.toList)))
    cproducts.foldLeft(0.0)(_ + _._2)
  }

  def getDiscountTotal(iterator: List[CartProduct]) : Double = {
    var totalAmount : Double = 0.0
    val otype = iterator.head.offerType
    val productPrice = iterator.head.product.price

    totalAmount = otype match{
      case OfferType.None => iterator.foldLeft(0.0)(_ + _.product.price)
      case OfferType.BuyOneGetOneFree => {
        (iterator.length / 2) * productPrice +  (iterator.length % 2) * productPrice
      }
      case OfferType.ThreeForTwo => {
        val teoProductsPrice = productPrice * 2
        (iterator.length / 3) * teoProductsPrice +  (iterator.length % 3) * productPrice
      }
    }
    totalAmount
  }
}
