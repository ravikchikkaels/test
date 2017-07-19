package Domain

/**
  * Created by CHIKKAR on 19/07/2017.
  */
object CurrentOffers
{
    val lstOffers = List(new Offer(Inventory.lstProducts.filter(p => p.name.equals("apple")).head, OfferType.BuyOneGetOneFree ),
      new Offer(Inventory.lstProducts.filter(p => p.name.equals("orange")).head, OfferType.ThreeForTwo ))

    def getOfferByProduct(product: Domain.Product) : Option[Offer] = {
      val pfilter = lstOffers.filter(x => x.product.name.equals(product.name))
      if(pfilter.isEmpty)
        None
      else
        Some(pfilter.head)
    }
}
