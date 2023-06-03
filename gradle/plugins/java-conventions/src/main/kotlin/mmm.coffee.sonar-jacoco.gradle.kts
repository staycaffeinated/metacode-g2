plugins {
    id("jacoco")
    id("org.sonarqube")
}


sonarqube {
    properties {
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        }
    }

// if we do this and Sonar isn't up, builds fail
//tasks.named("check") {
//    dependsOn("sonar")
//}