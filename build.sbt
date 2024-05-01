ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val hello = project.in(file("."))
  .settings(
    scalaVersion := "3.1.3",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test
  )



lazy val root = (project in file("."))
  .settings(
    name := "ti2-2024-1-e1-sopas"
  )
