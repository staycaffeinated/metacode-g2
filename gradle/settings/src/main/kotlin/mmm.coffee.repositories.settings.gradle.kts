
pluginManagement {
  includeBuild("../../gradle/plugins")
}

dependencyResolutionManagement {
  repositories.mavenCentral()
  repositories.google()

  // Platform for dependency versions shared by main build and build-logic
  includeBuild("../../gradle/platform")

  versionCatalogs.create("libs") {
    from(files("../../gradle/libs.versions.toml"))
  }

}

