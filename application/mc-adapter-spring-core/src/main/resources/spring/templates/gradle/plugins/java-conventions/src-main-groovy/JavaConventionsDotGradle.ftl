plugins {
    id "java-library"
    id "java-test-fixtures"
    id "org.example.testing"
    id "org.example.sonar-jacoco"
    id "org.example.jacoco"
    id "org.example.spotless"
    id "org.example.lint"
    id "org.example.docker"
}

// --------------------------------------------------------------------------------
// Enable compiling with a specific Java version,
// independent of the developer's current Java version.
// --------------------------------------------------------------------------------
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

// Share sources folder with other projects for aggregated JavaDoc and JaCoCo reports
configurations.create("transitiveSourcesElements") {
    visible = false
    canBeResolved = false
    canBeConsumed = true
    extendsFrom(configurations.implementation)
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage, Usage.JAVA_RUNTIME))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category, Category.DOCUMENTATION))
        attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named(DocsType, "source-folders"))
    }
    sourceSets.main.java.srcDirs.forEach { outgoing.artifact(it) }
}