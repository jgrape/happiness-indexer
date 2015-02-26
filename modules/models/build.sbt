
name := """models"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  javaEbean
)

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project. Found " + sys.props("java.specification.version"))
}
