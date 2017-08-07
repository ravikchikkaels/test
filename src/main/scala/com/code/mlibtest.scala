package com.code
import breeze.linalg.Matrix
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.ml.linalg.{Matrices, Matrix}
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.mllib.linalg.{Vector, Vectors}
/**
  * Created by chikkar on 25/07/2017.
  */
object mlibtest {


  def testf() = {
    val dVectorOne: Vector = Vectors.dense(1.0, 0.0, 2.0)
    println("dVectorOne:" + dVectorOne)
    //  Sparse vector (1.0, 0.0, 2.0, 3.0)
    // corresponding to nonzero entries.
    val sVectorOne: Vector = Vectors.sparse(4,  Array(0, 2,3),
      Array(1.0, 2.0, 3.0))
    // Create a sparse vector (1.0, 0.0, 2.0, 2.0) by specifying its
    // nonzero entries.
    val sVectorTwo: Vector = Vectors.sparse(4, Seq((0, 1.0), (2, 2.0),
      (3, 3.0)))


  }

  def main(args: Array[String]): Unit = {
    val detm = Matrices.dense(3, 3, Array(1.0, 3.0, 5.0, 2.0,
      4.0, 6.0, 2.0, 4.0, 5.0))


    detm



    val conf = new SparkConf().setMaster("local[1]").setAppName("ML 1")
    val sc = new SparkContext(conf)
    val denseData = Seq(
      Vectors.dense(0.0, 1.0, 2.1),
      Vectors.dense(3.0, 2.0, 4.0),
      Vectors.dense(5.0, 7.0, 8.0),
      Vectors.dense(9.0, 0.0, 1.1)
    )
    val sparseData = Seq(
      Vectors.sparse(3, Seq((1, 1.0), (2, 2.1))),
      Vectors.sparse(3, Seq((0, 3.0), (1, 2.0), (2, 4.0))),
      Vectors.sparse(3, Seq((0, 5.0), (1, 7.0), (2, 8.0))),
      Vectors.sparse(3, Seq((0, 9.0), (2, 1.0)))
    )

    val denseMat = new RowMatrix(sc.parallelize(denseData, 2))
    val sparseMat = new RowMatrix(sc.parallelize(sparseData, 2))

    println("Dense Matrix - Num of Rows :" + denseMat.numRows())
    println("Dense Matrix - Num of Cols:" + denseMat.numCols())
    println("Sparse Matrix - Num of Rows :" + sparseMat.numRows())
    println("Sparse Matrix - Num of Cols:" + sparseMat.numCols())




    sc.stop()
/*
    import org.apache.spark.mllib.tree.DecisionTree
    import org.apache.spark.mllib.tree.model.DecisionTreeModel
    import org.apache.spark.mllib.util.MLUtils

    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "C:\\Ravi\\MLIB\\sample_libsvm_data.txt")
    // Split the data into training and test sets (30% held out for testing)
    val splits = data.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    // Train a DecisionTree model.
    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    val numClasses = 2
    val categoricalFeaturesInfo = Map[Int, Int]()
    val impurity = "gini"
    val maxDepth = 5
    val maxBins = 32

    val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)

    // Evaluate model on test instances and compute test error
    val labelAndPreds = testData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    val testErr = labelAndPreds.filter(r => r._1 != r._2).count().toDouble / testData.count()
    println("Test Error = " + testErr)
    println("Learned classification tree model:\n" + model.toDebugString)

    // Save and load model
    model.save(sc, "target/tmp/myDecisionTreeClassificationModel")
    val sameModel = DecisionTreeModel.load(sc, "target/tmp/myDecisionTreeClassificationModel")
*/
  }

 /* def main(args: Array[String]): Unit = {

/*


    // Create a dense vector (1.0, 0.0, 3.0).
    val dv: Vector = Vectors.dense(1.0, 0.0, 3.0)
    // Create a sparse vector (1.0, 0.0, 3.0) by specifying its indices and values corresponding to nonzero entries.
    val sv1: Vector = Vectors.sparse(3, Array(0, 2), Array(1.0, 3.0))
    // Create a sparse vector (1.0, 0.0, 3.0) by specifying its nonzero entries.
    val sv2: Vector = Vectors.sparse(3, Seq((0, 1.0), (2, 3.0)))

   val sv3 : Vector = Vectors.sparse(4, Array(0, 2), Array(1.0, 5.4))

*/

    //println(dv)
    //println(sv1(1), sv1(2))


    val sm: Matrix = Matrices.sparse(4, 5,
      Array(0, 2, 3, 6, 7, 8),
      Array(0, 3, 1, 0, 2, 3, 2, 1),
      Array(1.0, 14.0, 6.0, 2.0, 11.0, 16.0, 12.0, 9.0))


    sm.toArray.foreach(println)
    println("1")
  }*/

}
