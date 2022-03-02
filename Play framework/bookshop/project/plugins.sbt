// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.13")

// Defines scaffolding (found under .g8 folder)
// http://www.foundweekends.org/giter8/scaffolding.html
// sbt "g8Scaffold form"
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.13.1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.2")


addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "LATEST_VERSION")
addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "5.0.2")

// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"