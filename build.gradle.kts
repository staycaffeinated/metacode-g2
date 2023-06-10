
/**
 * Within this project, this file is only used to define global lifecycle tasks.
 * This project follows the style of the 'idiomatic gradle' project found on github.
 * 
 * All subprojects are named with the prefix 'mc-' to make the custom tasks defined
 * here easier to code. 
 * 
 * Each subproject includes our mmm.coffee.lifecycle plugin so that each subproject
 * can inherit the equivalent checkAll/build tasks.
 */

val taskGroup = "Metacode build"

tasks.named<TaskReportTask>("tasks") {
  displayGroup = taskGroup
  doLast {
    println("\nTo work with a selected component, run ':<component>:tasks' (e.g: ':mc-annotations:tasks') for more information")
  }
}

val checkAll = tasks.register("checkAll") {
  group = taskGroup
  description = "Run all tests and create code coverage report"
  // dependsOn(gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map{ it.task(":checkAll")})
  gradle.includedBuilds.filter{ it.name.startsWith("mc-") }.map{ it.task(":check")}
}

val debugTask = tasks.register("list") {
  group = taskGroup
  description = "List all the projects"
  //dependsOn(gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map{ it.task(":clean")})
  // dependsOn(gradle.includedBuilds.filter{ it.name.isNotBlank() }.map {  println("Project: " + it.name) })
  gradle.includedBuilds.filter{ it.name.startsWith("mc-") }.map{ println(it.name)}
}

val clean = tasks.register("cleanAll") {
  group = taskGroup
  description = "Clean all the subprojects"
  gradle.includedBuilds.filter{ it.name.startsWith("mc-") }.map{ it.task(":clean")}
}

tasks.register("buildApp") {
  group = taskGroup
  description = "Run all tests and build the application's distribution"
  gradle.includedBuilds.filter{ it.name.startsWith("mc-") }.map{ it.task(":build")}
}

/**
 * Short-cut to copy the jar to my scratch directory for testing
 */
tasks.register("stage") {
  doLast {
    exec {
      workingDir = File(".")
      commandLine("./stageIt.sh")
    }
  }
}


