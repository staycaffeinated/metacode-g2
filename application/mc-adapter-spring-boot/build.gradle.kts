plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
    id("mmm.coffee.versioning")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-annotations")
    implementation("mmm.coffee.metacode:mc-adapter-spring-spi")

    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)
    
    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

sonar {
    properties {
        property("sonar.projectName", "mc-adapter-spring-boot")
        property("sonar.projectKey", "mmm.coffee.metacode:mc-adapter-spring-boot")
    }
}
