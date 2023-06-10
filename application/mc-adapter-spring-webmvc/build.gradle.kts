plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
}

group = "mmm.coffee.metacode"

dependencies {
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-annotations")
    implementation("mmm.coffee.metacode:mc-adapter-spring-spi")
    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)
    implementation(libs.slf4jApi)

    testImplementation("mmm.coffee.metacode:mc-adapter-spring-core")
    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)
}
