plugins {
    id 'org.example.java-conventions'
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.dependency.management)
    alias(libs.plugins.versions)
    alias(libs.plugins.lombok.plugin)
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
// Jib specific configuration for this application
// --------------------------------------------------------------------------------
jib {
    to {
        image = '${project.applicationName}'
        tags = [ '0.0.1' ]
    }
}