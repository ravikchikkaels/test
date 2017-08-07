package com.code

import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by chikkar on 31/07/2017.
  */
object Solution {
  def  makecandels(motors:Int, workers:Int) : Int = {
    return motors * workers
  }
  def main(args: Array[String]): Unit = {

/*    println(5 / 2) = 2
    println(5 % 2) = 1*/

    val x = "%06.2f".format(scala.math.Pi)


     val args1 = scala.io.Source.stdin.getLines().take(1).map(x => x.toString)
    //println(args1)
    var motors = 3 // sc.nextInt
    var workers : Int = 1 // sc.nextInt
    val unitprice : Int = 2 // sc.nextInt
    val totalCandlestoMake : Int = 12 // sc.nextInt

    val selectedPattern = getFactors(totalCandlestoMake).sortBy(x => x._3).take(1).head


    var totalMakeInStage : Int = 1
    var stages : Int  =0
    var exitOuterLoop = false
    while(totalMakeInStage <= totalCandlestoMake && !exitOuterLoop)
      {
          if(motors * workers <  totalCandlestoMake)
            {
              var t_totalMakeInStage =  makecandels(motors, workers)

              if(t_totalMakeInStage < totalCandlestoMake)
                {
                  if(t_totalMakeInStage > unitprice)
                    {
                      var availableUnitsToBuy = t_totalMakeInStage / unitprice
                      var exitfrom = false
                      while(availableUnitsToBuy > 0 && !exitfrom) {

                        if(motors <= workers) {
                          if (availableUnitsToBuy > 0) { // && motors < availableUnitsToBuy) { selectedPattern._1 > availableUnitsToBuy &&
                            motors = motors + 1
                            availableUnitsToBuy = availableUnitsToBuy - 1
                            t_totalMakeInStage = t_totalMakeInStage - 2
                          }
                        }

                        exitfrom =(motors * workers >= totalCandlestoMake)

                        if(!exitfrom) {
                          if ((selectedPattern._1 <= availableUnitsToBuy) || (workers <= motors)) {
                            if (availableUnitsToBuy > 0) { // && workers < availableUnitsToBuy) { // selectedPattern._2 > availableUnitsToBuy &&
                              workers = workers + 1
                              availableUnitsToBuy = availableUnitsToBuy - 1
                              t_totalMakeInStage = t_totalMakeInStage - 2
                            }
                          }
                        }
                      }

                      totalMakeInStage = availableUnitsToBuy * unitprice + t_totalMakeInStage

                    }
                  else
                    {
                      totalMakeInStage = t_totalMakeInStage
                    }
                }
            }
        else
          {
            exitOuterLoop = true
          }

            stages = stages + 1
      }

      println("stages =" + stages)

  }

  private def getFactors(n : Int) : ListBuffer[(Int, Int, Int)] = {
    var factors = new ListBuffer[(Int, Int, Int)]()
    for (i <- 1 to n / 2) {
      for (j <- 1 to n / 2) {
        if (i * j == n) {
          if (i > j)
            if (!factors.exists(x => x._1 == j && x._2 == i))
              factors.append((j, i, (i - j)))
            else
              factors.append((i, j, j - i))
        }
      }
    }

    factors
  }
}
