import play.PlayJava

name := """happiness-indexer"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")


libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.2.+",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  javaEbean
)

lazy val models = (project in file("modules/models"))
  .enablePlugins(PlayJava)

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .aggregate(models)
  .dependsOn(models)


initialize := {
  val _ = initialize.value
//  if (sys.props("java.specification.version") != "1.8")
//    sys.error("Java 8 is required for this project.")
}

