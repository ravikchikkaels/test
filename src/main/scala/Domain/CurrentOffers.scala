package Domain

import Domain.OfferType.OfferType

/**
  * Created by CHIKKAR on 19/07/2017.
  */


abstract class OfferMain
{
  val product : Product
  val offertype : OfferType
  def getPrice(cart:List[CartProduct]) : Double
}

class Offer1(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.BuyOneGetOneFree
  override def getPrice(iterator: List[CartProduct]): Double = {
    val productPrice = iterator.head.product.price
    (iterator.length / 2) * productPrice +  (iterator.length % 2) * productPrice
  }
}


class Offer2(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.ThreeForTwo
  override def getPrice(iterator: List[CartProduct]): Double = {
    val productPrice = iterator.head.product.price
    val teoProductsPrice = productPrice * 2
    (iterator.length / 3) * teoProductsPrice +  (iterator.length % 3) * productPrice
  }
}


class NoOffer(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.None
  override def getPrice(iterator: List[CartProduct]): Double = {
    iterator.foldLeft(0.0)(_ + _.product.price)
  }
}

object CurrentOffers
{

  //  val lstOffers = List(new Offer(Inventory.lstProducts.filter(p => p.name.equals("apple")).head, OfferType.BuyOneGetOneFree ),
   //   new Offer(Inventory.lstProducts.filter(p => p.name.equals("orange")).head, OfferType.ThreeForTwo ))

    val lstOffers = List(
      // Extend the list with new offers in future. The Offer will work out calculation.
            new Offer1(Inventory.lstProducts.filter(p => p.name.equals("apple")).head),
            new Offer2(Inventory.lstProducts.filter(p => p.name.equals("orange")).head)
    )

    def getOfferByProduct(product: Domain.Product) : Option[OfferMain] = {
      val pfilter = lstOffers.filter(x => x.product.name.equals(product.name))
      if(pfilter.isEmpty) Some(new NoOffer(product)) else Some(pfilter.head)
    }
}
