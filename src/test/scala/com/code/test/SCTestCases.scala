package com.code.test

/**
* Created by CHIKKAR on 18/07/2017.
*/
import Domain.Inventory
import org.scalatest.FlatSpec
import com.code._


object testContext
{
    val testProducts = Inventory.lstProducts
}

class SCTestCases extends FlatSpec {


    "test" should "fail if products greater than 2" in {
        assert(testContext.testProducts.length > 2)
    }

    "test" should "fail if orange and apple not in the inventory" in {
        assert(!testContext.testProducts.filter(x => x.name.equals("apple")).isEmpty)
        assert(!testContext.testProducts.filter(x => x.name.equals("orange")).isEmpty)
    }

    "test" should "fail if orange and apple not in the inventory" in {
        assert(!testContext.testProducts.filter(x => x.name.equals("apple")).isEmpty)
        assert(!testContext.testProducts.filter(x => x.name.equals("orange")).isEmpty)
    }

}