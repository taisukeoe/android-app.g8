# Android App in Scala

## About
This is [giter8](http://github.com/n8han/giter8) template for Android project with Scala 2.10, folked from [jberkel/android-app.g8](https://github.com/jberkel/android-app.g8) .

Due to [#SI-7253](https://issues.scala-lang.org/browse/SI-7253), I strongly recommend you to use **Scala2.10.2 or above**.

Please refer to [my blog article](http://taisukeoe.github.io/blog/2013/03/22/scala-2-dot-10-bytecode/) for more detail (only in Japanese, though).

## How to use

To use this template, g8 needs to be installed first. Read g8's
[readme](http://github.com/n8han/giter8#readme).

All done? Now fire up your favorite shell and enter

    g8 taisukeoe/android-app
    cd <name-of-app>
    sbt android:package-debug

## What you get

Your android sbt project contains 2 subprojects:

* MainProject
    * generated AndroidManifest.xml
    * Activity.scala (the "hello world" activity)
* TestProject (tests)
    * Integration tests, see [Android Testing](http://developer.android.com/guide/topics/testing/index.html)

## Installing & Running

    $ sbt
    $ android:emulator-start <tab>
    $ android:install-emulator

## How to run unit tests (src/test/scala/*)

    $ sbt
    > test
    [info] Specs:
    [info] a spec
    [info] - should do something
    [info] Passed: : Total 1, Failed 0, Errors 0, Passed 1, Skipped 0

## How to run integration tests (tests/src/main/scala/*)

The main apk under test needs to be installed first. Then:

    $ sbt
    > project tests
    > android:install-emulator
    > android:test-emulator
    [info]
    [info] my.android.project.tests.ActivityTests:.
    [info] my.android.project.tests.AndroidTests:..
    [info] Test results for InstrumentationTestRunner=...
    [info] Time: 1.492
    [info]
    [info] OK (3 tests)
