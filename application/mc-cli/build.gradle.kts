plugins {
    id("mmm.coffee.lifecycle")
    id("mmm.coffee.java-conventions")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.freefair.lombok") version "8.0.1"
}

group = "mmm.coffee.metacode"

dependencies {
    // Use this syntax to import a project dependency
    implementation("mmm.coffee.metacode:mc-annotations")
    implementation("mmm.coffee.metacode:mc-common")
    implementation("mmm.coffee.metacode:mc-generator-adapter-spring")
    implementation(libs.picocli)
    implementation(libs.guice)
    implementation(libs.slf4jApi)
    implementation(libs.logbackClassic)
    implementation(libs.vavr)
    implementation(libs.jakartaInject)

    testImplementation(platform(libs.junitBillOfMaterial))
    testImplementation(libs.junitJupiter)
    testImplementation(libs.junitSystemRules)
    testImplementation(libs.truth)
    testImplementation(libs.commonsBeanUtils)
    testImplementation(libs.mockito)
    testImplementation(libs.systemLambda)
}


 application {
      //mainClass.set("mmm.coffee.zen.cli.CodeZenApplication")
     mainClass.set("mmm.coffee.metacode.cli.Application" ) // shadowJar needs this syntax
     applicationName = "metacode"
 }


/**
 shadowJar {
     archiveBaseName.set('metacode')
     manifest {
         // note: ManifestVersionProvider has a dependency on the impl-title's value
         attributes "Implementation-Title": "MetaCode"
         // note: the 'version' is defined in this component's gradle.properties
         attributes "Implementation-Version": archiveVersion
     }
 }
**/

/**
 * // ----------------------------------------------------------------
 * // When the distribution tar/zip file is the published artifact,
 * // a jar is included for each module: the tar/zip file contains
 * // a 'lib/meta-annotations-x.y.z.jar, lib/meta-cli-x.y.z.jar,
 * // lib/meta-common-x.y.z.jar, and so on. The gist is, there's no
 * // primary MANIFEST.MF file like the one found in an uber jar
 * // (as generated by shadowjar). PicoCLI expects to find _some_
 * // MANIFEST file that reveals the implementation-version of
 * // MetaCode. We'll put that in the meta-cli-x.y.z.jar's manifest.
 * // ---------------------------------------------------------------- */
/**
 jar {
     manifest {
         attributes "Implementation-Title": "MetaCode"
         attributes "Implementation-Version": archiveVersion
     }
 }
**/
