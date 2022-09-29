ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"

lazy val root = (project in file("."))
  .settings(
    name := "payla-word-counter"
  )

libraryDependencies ++= Seq(
  Library.FinchxCore,
  Library.FinchxCirce,
  Library.Circe,
  Library.Json4s,
  Library.Json4sJackson,
  Library.ScalaTest,
  Library.Logback,
  Library.ScalaLogging
)
