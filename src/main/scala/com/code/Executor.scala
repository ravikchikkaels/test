/**
  * Created by CHIKKAR on 17/07/2017.
  */

package com.code

import Domain.{Checkout, Inventory, ShoppingCart}

//val productsByName = cart.getAllProducts().groupBy(x => x.product.name)

    //val x = CurrentOffers.getOfferByProduct(test)
    /*cart.getAllProducts().foldLeft(0.0)((t, c) =>{
      t + c.product.price
    })







    //(_ + _.product.price)

*/

object Executor {
  def main(args: Array[String]): Unit = {

    var itemIndexer : Int = 0
    val cart = new ShoppingCart()

    val apple : Domain.Product = Inventory.lstProducts.filter(x => x.name.equals("apple")).head
    val orange : Domain.Product = Inventory.lstProducts.filter(x => x.name.equals("orange")).head
    //val test : Domain.Product = Inventory.lstProducts.filter(x => x.name.equals("test")).head

    itemIndexer = itemIndexer + 1

   /* cart.AddProduct(apple)
    cart.AddProduct(apple)
    cart.AddProduct(apple)
    cart.AddProduct(apple)
    cart.AddProduct(apple)
    cart.AddProduct(apple)*/


    cart.AddProduct(orange)
    cart.AddProduct(orange)
    cart.AddProduct(orange)
    cart.AddProduct(orange)
   /* cart.AddProduct(orange)
    cart.AddProduct(orange)
    cart.AddProduct(orange)*/

   // cart.AddProduct(test)



    println(Checkout.getCheckoutTotal(cart))

  }
}
