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
    implementation("mmm.coffee.metacode:mc-adapter-spring-batch")
    implementation("mmm.coffee.metacode:mc-adapter-spring-boot")
    implementation("mmm.coffee.metacode:mc-adapter-spring-core")
    implementation("mmm.coffee.metacode:mc-adapter-spring-webmvc")
    implementation("mmm.coffee.metacode:mc-adapter-spring-webflux")

    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    implementation(libs.commonsConfig)
    implementation(libs.commonsIo)
    implementation(libs.commonsLang3)
    implementation(libs.jmustache)
    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)
    implementation(libs.slf4jApi)
    implementation(libs.jakartaInject)
    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)

    integrationTestImplementation(libs.commonsConfig)
    integrationTestImplementation(libs.freemarker)
    integrationTestImplementation(platform(libs.junitBillOfMaterial))
    integrationTestImplementation(libs.junitJupiter)
    integrationTestImplementation(libs.junitSystemRules)
    integrationTestImplementation(libs.truth)
    integrationTestImplementation(libs.mockito)
    integrationTestImplementation("mmm.coffee.metacode:mc-common")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-spi")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-batch")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-boot")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-core")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-webmvc")
    integrationTestImplementation("mmm.coffee.metacode:mc-adapter-spring-webflux")
}
