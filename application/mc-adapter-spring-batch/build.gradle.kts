plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-annotations")
    implementation("mmm.coffee.metacode:mc-adapter-spring-spi")

    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)

    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)
}

sonar {
    properties {
        property("sonar.projectName", "mc-adapter-spring-batch")
        property("sonar.projectKey", "mmm.coffee.metacode:mc-adapter-spring-batch")
    }
}