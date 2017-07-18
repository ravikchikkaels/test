/**
  * Created by CHIKKAR on 17/07/2017.
  */

package com.code

class Product(val name : String,val price : Double)

class CartProduct(override val name : String,override val price : Double,val Index : Int ) extends Product(name, price)


object Inventory{
  val lstProducts = List(new Product("apple", 0.6), new Product("orange", 0.25) )
}


class ShoppingCart{
  private var lstProducts = List[CartProduct]()

  def AddProduct(p : CartProduct): Unit ={
    lstProducts = p :: lstProducts
  }

  def getAllProducts() : List[CartProduct] = {
    lstProducts
  }
}
class checkout
{
  def getCheckoutTotal(cart : ShoppingCart):Double = {
    cart.getAllProducts().foldLeft(0.0)(_ + _.price)
  }
}



object Executor {
  def main(args: Array[String]): Unit = {


    // println("hello world!")
  /*  val lst = List(user("r1", 1), user("r2", 2), user("r3", 3))
    val names = for( u <- lst) yield u.name


    for(i <- names) println(i)*/

  }

}
