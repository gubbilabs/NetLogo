import sbt._
import Keys._

object Running {

  // the NetLogo app cannot be cleanly shut down, so we need a fresh JVM
  val settings = Seq(
    fork in run := true,
    javaOptions in run ++= Seq(
      "-XX:-OmitStackTraceInFastThrow",  // issue #104
      "-XX:MaxPermSize=128m",
      "-Xmx1024m",
      "-Dfile.encoding=UTF-8",
      // sunjce_provider.jar is needed for https connection to GitHub.
      // but surely there was a reason to clear java.ext.dirs
      // so this should NOT be merged like this - NP 2014-05-04.
      // "-Djava.ext.dirs=",
      "-Dapple.awt.graphics.UseQuartz=true") ++
    (if(System.getProperty("os.name").startsWith("Mac"))
      Seq("-Xdock:name=NetLogo")
     else Seq()) ++
    (if(System.getProperty("org.nlogo.is3d") == "true")
      Seq("-Dorg.nlogo.is3d=true")
     else Seq()) ++
    (if(System.getProperty("org.nlogo.noGenerator") == "true")
      Seq("-Dorg.nlogo.noGenerator=true")
     else Seq())
    )

}
