pluginManagement {
    includeBuild("../../gradle/settings")
}

plugins {
    id("mmm.coffee.repositories")
}

dependencyResolutionManagement {
    includeBuild("../mc-annotations")
}


