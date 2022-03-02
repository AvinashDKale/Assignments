name := "helloworldsbt"
organization := "com.domainame.example"
version := "1.0-SNAPSHOT"
lazy val hello = taskKey[Unit]("Custom Task")
lazy val root = (project in file(".")).settings(
 hello := { println("This is a custom task !!") }
)
scalaVersion := "2.13.0"
