resolvers += Resolver.url("scalasbt snapshots", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns)

addSbtPlugin("org.scala-sbt" % "sbt-android-plugin" % "0.6.3-20130429-SNAPSHOT")

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
 
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.0-SNAPSHOT")
