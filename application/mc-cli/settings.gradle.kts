pluginManagement {
    includeBuild("../../gradle/settings")
}

plugins {
    id("mmm.coffee.repositories")
}

dependencyResolutionManagement {
    includeBuild("../mc-common")
    includeBuild("../mc-annotations")
    includeBuild("../mc-adapter-spring-core")
}


