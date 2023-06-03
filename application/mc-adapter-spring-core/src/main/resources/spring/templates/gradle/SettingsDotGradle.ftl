pluginManagement {
    includeBuild("./gradle/settings")
}

plugins {
    id "org.example.repositories"
}

rootProject.name = '${project.applicationName}'
