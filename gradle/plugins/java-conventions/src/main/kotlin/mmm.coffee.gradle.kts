plugins {
  id("java-library")
  id("java-test-fixtures")
  id("mmm.coffee.jacoco")
}

dependencies {
  implementation(platform("mmm.coffee.metacode.gradel:platform"))
  }

// Configure details of Java compilation
tasks.withType<JavaCompile>().configureEach {
  options.headerOutputDirectory.convention(null as Directory?) // currently, need to clear convention to remove it
  }


// Share sources folders with other projects for aggregated JavaDocs and JaCoCo reports
configuration.create("transitiveSourcesElements") {
  isVisible = false
  isCanBeResolved = false
  isCanBeConsumed = true
  extendsFrom(configurations.implementation.get())
  attributes {
    attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION)
    attribute(DocTypes.DOCS_TYPE_ATTRIBUTE, objects.named("source-folders"))
    }

  sourceSets.main.get().java.srcDirs.forEach { outgoing.artifacts(it) }
}



