import sbt._
import Keys._

import org.scalasbt.androidplugin._
import AndroidKeys._

object General {
  val settings = Defaults.defaultSettings ++ Seq (
    name := "$name$",
    version := "0.1",
    versionCode := 0,
    scalaVersion := "$scala_version$",
    platformName in Android := "android-$target_api_level$"
  )

   val proOpt = Seq(
    "-keep class android.support.v4.app.** { *; }",
    "-keep interface android.support.v4.app.** { *; }",
    "-keep class com.android.vending.billing.**",
    /* 
       Since SI-5379 is not fixed yet, you need a below line. 
       See https://issues.scala-lang.org/browse/SI-5397 for more detail.
     */
    "-keep class scala.collection.SeqLike { public protected *;}" 
  )

  val proguardSettings = Seq (
    useProguard in Android := $useProguard$,
    proguardOption in Android := proOpt.mkString(" ")
  )

  lazy val fullAndroidSettings =
    General.settings ++
    AndroidProject.androidSettings ++
 // TypedResources.settings ++
    proguardSettings ++
    AndroidManifestGenerator.settings ++
    AndroidMarketPublish.settings ++ Seq (
      keyalias in Android := "change-me",
      keystorePath in Android := Path.userHome / "foo.keystore",
      libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"
    )
}

object AndroidBuild extends Build {
  lazy val main = Project (
    "$name$",
    file("."),
    settings = General.fullAndroidSettings
  )

  lazy val tests = Project (
    "tests",
    file("tests"),
    settings = General.settings ++
               AndroidTest.settings ++
               General.proguardSettings ++ Seq (
      name := "$name$Tests"
    )
  ) dependsOn main
}
