enablePlugins(ScalaJSPlugin)

name := "text2flow"
scalaVersion := "2.12.3"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2"

mainClass := Some("com.nitrograph.text2flow.client.Text2Flow")

enablePlugins(GitBranchPrompt)
