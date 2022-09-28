import sbt._

object Version {
  final val FinchxCore = "0.33.0"
  final val Circe = "0.15.0-M1"
  final val Json4s = "4.0.5"
  final val ScalaTest = "3.2.12"
  final val Logback = "1.4.1"
  final val ScalaLogging = "3.9.5"
}

object Library {
  val FinchxCore = "com.github.finagle" %% "finchx-core" % Version.FinchxCore
  val FinchxCirce = "com.github.finagle" %% "finchx-circe" % Version.FinchxCore
  val Circe = "io.circe" %% "circe-generic" % Version.Circe
  val Json4s = "org.json4s" %% "json4s-native" % Version.Json4s
  val Json4sJackson = "org.json4s" %% "json4s-jackson" % Version.Json4s
  val ScalaTest = "org.scalatest" %% "scalatest" % Version.ScalaTest % "test"
  val Logback = "ch.qos.logback" % "logback-classic" % Version.Logback % Runtime
  val ScalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % Version.ScalaLogging
}