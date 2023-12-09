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

val checkApp = tasks.register("checkApp") {
    group = taskGroup
    description = "Run all tests and create code coverage report"
    dependsOn(gradle.includedBuild("mc-adapter-spring-batch").task(":check"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-boot").task(":check"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-core").task(":check"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-spi").task(":check"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webflux").task(":check"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webmvc").task(":check"))
    dependsOn(gradle.includedBuild("mc-annotations").task(":check"))
    dependsOn(gradle.includedBuild("mc-common").task(":check"))
    dependsOn(gradle.includedBuild("mc-generator-spring").task(":check"))
    dependsOn(gradle.includedBuild("mc-cli").task(":check"))

}

val cleanApp = tasks.register("cleanApp") {
    group = taskGroup
    description = "Clean all submodule artifacts"
    // dependsOn(gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map{ it.task(":clean")})
    dependsOn(gradle.includedBuild("mc-adapter-spring-batch").task(":clean"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-boot").task(":clean"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-core").task(":clean"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-spi").task(":clean"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webflux").task(":clean"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webmvc").task(":clean"))
    dependsOn(gradle.includedBuild("mc-annotations").task(":clean"))
    dependsOn(gradle.includedBuild("mc-common").task(":clean"))
    dependsOn(gradle.includedBuild("mc-generator-spring").task(":clean"))
    dependsOn(gradle.includedBuild("mc-cli").task(":clean"))
}

val debugTask = tasks.register("list") {
    group = taskGroup
    description = "List all the projects"
    gradle.includedBuilds.filter { it.name.startsWith("mc-") }.map { println(it.name) }
}

tasks.register("buildApp") {
    group = taskGroup
    description = "Run all tests and build the application's distribution"
    dependsOn(gradle.includedBuild("mc-adapter-spring-batch").task(":build"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-boot").task(":build"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-core").task(":build"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-spi").task(":build"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webflux").task(":build"))
    dependsOn(gradle.includedBuild("mc-adapter-spring-webmvc").task(":build"))
    dependsOn(gradle.includedBuild("mc-annotations").task(":build"))
    dependsOn(gradle.includedBuild("mc-common").task(":build"))
    dependsOn(gradle.includedBuild("mc-generator-spring").task(":build"))
    dependsOn(gradle.includedBuild("mc-cli").task(":build"))
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

/**
 * Generate code coverage for each module and publish to sonar
 */
tasks.register("codeCoverage") {
    doLast {
        exec {
            workingDir = File(".")
            commandLine("./coverage.sh")
        }
    }
}




