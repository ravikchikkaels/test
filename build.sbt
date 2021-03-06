name := "DB_HW"

version := "1.0"

scalaVersion := "2.11.8"


// https://mvnrepository.com/artifact/org.scalatest/scalatest_2.11
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.6.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib_2.10
libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "1.3.0" % "provided"

libraryDependencies  ++= Seq(
  // Last stable release
  "org.scalanlp" %% "breeze" % "0.13.1",

  // Native libraries are not included by default. add this if you want them (as of 0.7)
  // Native libraries greatly improve performance, but increase jar sizes.
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  "org.scalanlp" %% "breeze-natives" % "0.13.1",

  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  "org.scalanlp" %% "breeze-viz" % "0.13.1"
)