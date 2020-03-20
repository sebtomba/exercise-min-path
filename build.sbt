val additionalScalacOptions = Seq(
  "-target:jvm-1.8",
  "-encoding",
  "UTF-8",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Xlint:adapted-args",
  "-Xlint:infer-any",
  "-Xlint:unused",
  "-Wdead-code",
  "-Werror",
  "-Xlint"
)

val projectSettings = Seq(
  name := "min-path",
  description := "Create a REST application with a single convert endpoint",
  version := "1.0",
  scalaVersion := "2.13.1",
  organization := "Sebastian Bach",
  scalacOptions ++= additionalScalacOptions
)

val http4sVersion = "0.21.0-RC4"
val circeVersion = "0.13.0-RC1"

val dependencies = Seq(
  "org.typelevel" %% "cats-core" % "2.1.0",
  "org.scalatest" % "scalatest_2.13" % "3.1.0" % "test"
)

lazy val root = (project in file("."))
  .settings(projectSettings: _*)
  .settings(libraryDependencies ++= dependencies)
