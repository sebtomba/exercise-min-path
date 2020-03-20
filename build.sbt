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
  description := "Finds the minimal path in a triangle of numbers",
  version := "1.0",
  scalaVersion := "2.13.1",
  organization := "Sebastian Bach",
  scalacOptions ++= additionalScalacOptions,
  mainClass in assembly := Some("Main")
)

val dependencies = Seq(
  "org.typelevel" %% "cats-core" % "2.1.0",
  "org.scalatest" % "scalatest_2.13" % "3.1.0" % "test"
)

lazy val root = (project in file("."))
  .settings(projectSettings: _*)
  .settings(libraryDependencies ++= dependencies)
