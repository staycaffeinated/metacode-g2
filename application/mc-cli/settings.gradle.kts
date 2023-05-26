pluginManagement {
    includeBuild("../../gradle/settings")
}

plugins {
    id("mmm.coffee.repositories")
}

// I'm not sure this stanza is required. So far, things are working
// without it, but the idiomatic example includes it.
/**
dependencyResolutionManagement {
    includeBuild("../mc-common")
}
**/


