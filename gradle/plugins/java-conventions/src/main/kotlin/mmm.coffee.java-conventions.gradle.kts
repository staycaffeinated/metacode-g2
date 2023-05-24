
plugins {
  id("java-library")
  id("java-test-fixtures")
}


// Configure details of Java compilation
tasks.withType<JavaCompile>().configureEach {
  options.headerOutputDirectory.convention(null as Directory?) // currently, need to clear conventions to remove
}



// Share sources folder with other projects for aggregated JavaDoc and JaCoCo reports
configurations.create("transitiveSourcesElements") {
  isVisible = false
  isCanBeResolved = false
  isCanBeConsumed = true
  extendsFrom(configurations.implementation.get())
  attributes {
    attribute (Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
    attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named("source-folders"))
  }
  sourceSets.main.get().java.srcDirs.forEach { outgoing.artifact(it) }
}

