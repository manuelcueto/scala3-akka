val scala3Version = "3.0.0-RC1"

val AkkaVersion = "2.6.13"

val scala3Deps = Seq("org.typelevel" %% "discipline-scalatest" % "2.1.2" % Test)
val scala2Deps = Seq(
"com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
"com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= scala2Deps.map(_.withDottyCompat(scalaVersion.value)) ++ scala3Deps
  )
