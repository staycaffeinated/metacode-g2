rootProject.name = "metacode-g2"

dependencyResolutionManagement {
    includeBuild("gradle/plugins")

    includeBuild("application/mc-annotations")
    includeBuild("application/mc-cli")
    includeBuild("application/mc-common")
    includeBuild("application/mc-generator")

    includeBuild("application/mc-adapter-spring-core")
    includeBuild("application/mc-adapter-spring-batch")
    includeBuild("application/mc-adapter-spring-boot")
    includeBuild("application/mc-adapter-spring-spi")
    includeBuild("application/mc-adapter-spring-webmvc")
    includeBuild("application/mc-adapter-spring-webflux")

}

