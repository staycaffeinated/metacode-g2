
plugins {
  `kotlin-dsl`
  }

group = "mmm.coffee.buildlogic"

dependencies {
  implementation(platform("mmm.coffee.metacode:platform"))
  compileOnly("org.projectlombok:lombok:1.18.28")
  }


