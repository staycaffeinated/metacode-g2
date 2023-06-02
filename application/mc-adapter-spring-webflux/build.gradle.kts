plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
    id("io.freefair.lombok") version "8.0.1"
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
}
