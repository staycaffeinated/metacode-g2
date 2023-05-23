

val taskGroup = "Metacode build"
/**
tasks.named<TaskReportTask>("tasks") {
  displayGroup = taskGroup
  doLast {
    println("\nTo work with a selected component, run ':<component>:tasks' (e.g: ':mc-annotations:tasks') for more information")
  }
}

val checkAll = tasks.register("checkAll") {
  group = taskGroup
  description = "Run all tests and create code coverage report"

  // TODO: Need to tweak this to find our components
  dependsOn(gradle.includeBuilds.filter { it.name.startsWith("mc-") }.map { it.task(":checkAll") {)

}

tasks.register("build") {
  group = taskGroup
  description = "Run all tests and build the application's distribution"
  dependsOn(checkAll)
  }
**/

