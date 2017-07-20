package Domain

import Domain.OfferType.OfferType

/**
  * Created by CHIKKAR on 19/07/2017.
  */


abstract class OfferMain
{
  val product : Product
  val offertype : OfferType
  def getPrice(cproduct:CartProduct, count: Int) : Double
}

class Offer1(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.BuyOneGetOneFree
  //override def getPrice(iterator: List[CartProduct]): Double = {
  override def getPrice(cproduct:CartProduct, count: Int): Double = {
    val productPrice = cproduct.product.price
    (count / 2) * productPrice +  (count % 2) * productPrice
  }
}


class Offer2(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.ThreeForTwo
  override def getPrice(cproduct:CartProduct, count: Int): Double = {
    val productPrice = cproduct.product.price
    val teoProductsPrice = productPrice * 2
    (count / 3) * teoProductsPrice +  (count % 3) * productPrice
  }
}


class NoOffer(val p : Product) extends OfferMain
{
  override val product: Product = p
  override val offertype: OfferType = OfferType.None
  override def getPrice(cproduct:CartProduct, count: Int): Double = {
    cproduct.product.price * count
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
