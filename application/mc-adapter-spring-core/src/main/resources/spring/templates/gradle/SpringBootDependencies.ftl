dependencies {
    annotationProcessor libs.springBootConfigProcessor

    developmentOnly libs.springDevTools

    implementation libs.springBootStarterActuator
    implementation libs.springBootStarterWeb

    // Optional: this reports out-of-date property names.
    runtimeOnly libs.springBootPropertiesMigrator

    testImplementation (libs.springBootStarterTest){
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
    testImplementation (platform( libs.junitBillOfMaterial ))
    testImplementation (libs.junitJupiter)
}