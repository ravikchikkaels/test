package com.code

import breeze.linalg.{DenseMatrix, Matrix, SparseVector}
import org.apache.spark.ml.linalg.Matrices

/**
  * Created by chikkar on 26/07/2017.
  */
object breezetest {
  def main(args: Array[String]): Unit = {

    //dense vectors
    import breeze.linalg.DenseVector
    /*val v = DenseVector(2f, 0f, 3f, 2f, -1f)
    println(v)
    v.update(3, 6f)
    println(v)


    //sparsevectors


    val sv:SparseVector[Double] =   SparseVector(5)()
    sv(0) = 1
    sv(2) = 3
    sv(4) = 5
    val m:SparseVector[Double] = sv.mapActivePairs((i,x) => x+1)
    println(": n " + m)
*/
    val a = DenseMatrix((1,2),(3,4))
    val b = DenseMatrix((2,2),(2,2))

    val d  = a + b

    println(" a : n" + a)


    println(" B : n" + b)

    println(" a + B : n" + d)



  }
}
