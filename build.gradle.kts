
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
  dependsOn(gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map{ it.task(":checkAll")})
}

val clean = tasks.register("clean") {
  group = taskGroup
  description = "Run 'clean' on each subproject"
  dependsOn(gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map{ it.task(":clean")})
}


tasks.register("build") {
  group = taskGroup
  description = "Run all tests and build the application's distribution"
  dependsOn(checkAll)
}


