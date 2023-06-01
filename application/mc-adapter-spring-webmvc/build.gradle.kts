plugins {
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.lifecycle")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-annotations")
    implementation("mmm.coffee.metacode:mc-generator-adapter-spring")
    implementation(libs.freemarker)
    implementation(libs.guice)
    implementation(libs.jacksonYaml)
}
