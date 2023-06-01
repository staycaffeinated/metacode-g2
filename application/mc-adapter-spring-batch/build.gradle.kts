
plugins {
  id("mmm.coffee.java-conventions")
  id("mmm.coffee.lifecycle")
}

group = "mmm.coffee.metacode"

dependencies {
  implementation(libs.freemarker)
  implementation(libs.guice)
  implementation(libs.jacksonYaml)
}
