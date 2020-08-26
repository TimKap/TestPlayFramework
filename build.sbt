name := "myApp"
organization := "ru.tkapkaev"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "ch.qos.logback" % "logback-classic" % "1.2.3"


)
PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "ru.tkapkaev.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport + ru= "ru.tkapkaev.binders._"
scalacOptions ++= Seq(  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:postfixOps",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
//  "-Xlint",
  "-Xfatal-warnings",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen")

fork := true