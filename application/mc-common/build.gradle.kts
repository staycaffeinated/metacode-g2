plugins {
    id("mmm.coffee.lifecycle")
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.versioning")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation ("mmm.coffee.metacode:mc-annotations")
    
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    implementation(libs.commonsBeanUtils)
    implementation(libs.commonsConfig)
    implementation(libs.commonsIo)
    implementation(libs.commonsLang3)
    implementation(libs.jakartaAnnotations)
    implementation(libs.jmustache)
    implementation(libs.picocli)
    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.guava)
    implementation(libs.jacksonYaml)
    implementation(libs.slf4jApi)

    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)

    integrationTestImplementation(platform(libs.junitBillOfMaterial))
    integrationTestImplementation(libs.junitJupiter)
    integrationTestImplementation(libs.junitSystemRules)
    integrationTestImplementation(libs.truth)
    integrationTestImplementation(libs.mockito)
}

sonar {
    properties {
        property("sonar.projectName", "mc-common")
        property("sonar.projectKey", "mmm.coffee.metacode:mc-common")
    }
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

