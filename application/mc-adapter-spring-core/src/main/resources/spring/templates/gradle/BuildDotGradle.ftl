plugins {
    id 'org.example.java-conventions'
    id 'org.springframework.boot' version '${project.springBootVersion}'
    id 'io.spring.dependency-management' version '${project.springDependencyManagementVersion}'
    id 'com.github.ben-manes.versions' version '${project.benManesPluginVersion}'
    id 'io.freefair.lombok' version '${project.lombokPluginVersion}'
}

version='0.0.1'


// --------------------------------------------------------------------------------
// Dependencies
// --------------------------------------------------------------------------------
<#if (project.isWebFlux())>
    <#include "SpringWebFluxDependencies.ftl">
<#elseif (project.isWebMvc())>
    <#include "SpringWebMvcDependencies.ftl">
<#elseif (project.isSpringBatch())>
    <#include "SpringBatchDependencies.ftl">
<#else>
    <#include "SpringBootDependencies.ftl">
</#if>


// --------------------------------------------------------------------------------
// Make all tests use JUnit 5
// --------------------------------------------------------------------------------
tasks.withType(Test) {
    useJUnitPlatform()
    testLogging { events "passed", "skipped", "failed" }
}

// --------------------------------------------------------------------------------
// Jib specific configuration for this application
// --------------------------------------------------------------------------------
jib {
    to {
        image = '${project.applicationName}'
        tags = [ '0.0.1' ]
    }
}
