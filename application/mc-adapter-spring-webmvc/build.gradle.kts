
plugins {
  id("mmm.coffee.java-conventions")
  id("mmm.coffee.lifecycle")
}

dependencies {
  implementation(libs.freemarker)
  implementation(libs.guice)
  implementation(libs.jacksonYaml)
}
