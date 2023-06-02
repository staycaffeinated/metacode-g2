plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
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
}
