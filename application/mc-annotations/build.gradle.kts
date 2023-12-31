plugins {
    id("mmm.coffee.lifecycle")
    id("mmm.coffee.java-conventions")
    id("mmm.coffee.versioning")
}

group = "mmm.coffee.metacode"

dependencies {
    implementation ( libs.guice )
    implementation ( libs.jakartaInject )

    testImplementation ( platform(libs.junitBillOfMaterial) )
    testImplementation ( libs.junitJupiter )
    testImplementation ( libs.junitSystemRules )
    testImplementation ( libs.truth )
    testImplementation ( libs.mockito )
    testImplementation ( libs.systemLambda )

    integrationTestImplementation ( platform(libs.junitBillOfMaterial) )
    integrationTestImplementation ( libs.junitJupiter )
    integrationTestImplementation ( libs.junitSystemRules )
    integrationTestImplementation ( libs.truth )
    integrationTestImplementation ( libs.mockito )
    integrationTestImplementation ( libs.systemLambda )
}

