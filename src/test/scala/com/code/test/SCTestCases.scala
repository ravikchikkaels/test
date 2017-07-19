package com.code.test

/**
* Created by CHIKKAR on 18/07/2017.
*/
import Domain.Inventory
import org.scalatest.FlatSpec
import com.code._




class SCTestCases extends FlatSpec {
  // tests go here...
    "test" should "fail if products greater than 2" in {
        assert(Inventory.lstProducts.length <= 2)
    }

}