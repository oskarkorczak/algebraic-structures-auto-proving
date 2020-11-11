import Dependencies._

ThisBuild / organization := "org"
ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.0.1-SNAPSHOT"

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:_",
  "-unchecked",
  "-Wunused:_",
  "-Xfatal-warnings",
  "-Ymacro-annotations"
)

lazy val `property-based-testing-exercises` =
  project
    .in(file("."))
    .settings(
      name := "property-based-testing-exercises",
      libraryDependencies ++= Seq(
        // main dependencies
      ),
      libraryDependencies ++= Seq(
        scalaTest,
        scalaCheck
      ).map(_ % Test),
      Compile / console / scalacOptions --= Seq(
        "-Wunused:_",
        "-Xfatal-warnings"
      ),
      Test / console / scalacOptions :=
        (Compile / console / scalacOptions).value
    )
