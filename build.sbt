name := "SBTAssignment"

version := "0.1"

scalaVersion := "2.13.4"

lazy val common = project.in(file("common"))
  .settings(
    libraryDependencies ++= Seq( "com.typesafe" % "config" % "1.4.1" ,
      "org.slf4j" % "slf4j-log4j12" % "1.7.30" % Test ,
      "org.json4s" %% "json4s-native" % "3.7.0-M7" ,
    "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test ,
    "org.mockito" %% "mockito-scala" % "1.16.15")
  )

lazy val persistence = project.in(file("persistence"))
  .settings(
    libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.3.3" ,
      "org.postgresql" % "postgresql" % "42.2.18" ,
      "com.h2database" % "h2" % "1.4.200" % Test)
  ).dependsOn(common)

lazy val root = project.in(file(".")).aggregate(common, persistence)

