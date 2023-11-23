plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
    id("mmm.coffee.versioning")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-annotations")
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)
}

