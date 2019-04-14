name := """TestPlayFramework"""
organization := "ru.tkapkaev"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test
PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "ru.tkapkaev.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "ru.tkapkaev.binders._"
