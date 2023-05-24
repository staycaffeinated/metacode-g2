
rootProject.name="metacode-kotlin"

dependencyResolutionManagement {
  includeBuild("gradle/plugins")


  includeBuild("application/mc-annotations")
  includeBuild("application/mc-cli")
  includeBuild("application/mc-generator")
  includeBuild("application/mc-generator-adapter-spring/generator-spring-batch")

  includeBuild("application/mc-generator-adapter-spring/generator-spring-boot")
  includeBuild("application/mc-generator-adapter-spring/generator-spring-shared")
  includeBuild("application/mc-generator-adapter-spring/generator-spring-webmvc")
  includeBuild("application/mc-generator-adapter-spring/generator-spring-webflux")

}

