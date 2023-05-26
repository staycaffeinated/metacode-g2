plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
}

group = "mmm.coffee.metacode"


dependencies {
    implementation ("mmm.coffee.metacode:mc-common" )
    implementation ("mmm.coffee.metacode:mc-annotations")

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

    // testImplementation project (path: ':meta-common' )
    // testImplementation project (path: ':meta-annotations')

    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.mockito)
}