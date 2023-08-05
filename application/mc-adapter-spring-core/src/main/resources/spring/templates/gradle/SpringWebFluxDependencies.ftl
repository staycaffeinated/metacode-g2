dependencies {
    annotationProcessor libs.springBootConfigProcessor

    developmentOnly libs.springDevTools

    /**
     * If springboot 3.1.0 is used, you must include the latest spring-orm library.
     * The older spring-orm library refers to PostgreSQL95Dialect which is deprecated
     * and has been removed since at least hibernate-core:6.2.2.Final,
     * so the application hits a ClassNotFoundException: PostgresSQL95Dialect exception.
     * The correct dialect is PostgresPlusDialect, but one of the older spring-orm
     * classes has a hard-coded ref to PostgreSQL95Dialect. This is resolved in spring-orm:6.0.10.
     */
    implementation libs.springOrm

    implementation libs.jacksonDatatypeJsr310
    implementation libs.r2dbcSpi
    implementation libs.springBootStarterDataR2dbc
    implementation libs.springBootStarterAop
    implementation libs.springBootStarterActuator
    implementation libs.springBootStarterWebFlux
    implementation libs.springBootStarterValidation
    implementation libs.problemSpringWebFlux
    implementation libs.problemJacksonDataType
    implementation libs.jakartaPersistenceApi
<#if project.isWithOpenApi()>
    implementation libs.openApiStarterWebfluxUI
</#if>
<#if (project.isWithLiquibase())>
    implementation libs.liquibaseCore
</#if>
<#if (project.isWithPostgres())>
    implementation libs.r2dbcPostgres
    runtimeOnly libs.postgresql
<#else>
    implementation libs.r2dbcH2
    runtimeOnly libs.h2
</#if>
<#if (project.isWithTestContainers())>
    testImplementation libs.springCloud
    testImplementation platform( libs.testContainersBom )
    testImplementation libs.testContainersJupiter
    testImplementation libs.springBootTestContainers
    testImplementation libs.springDevTools
    <#if (project.isWithPostgres())> <#-- if (testcontainers && postgres) -->
    testImplementation libs.testContainersPostgres
    </#if>
<#else>
<#-- if testcontainers aren't in use, default to using H2 to enable -->
<#-- out-of-the-box tests to work until a QA DB is set up by the developer. -->
    testRuntimeOnly libs.h2
</#if>
    testAnnotationProcessor libs.lombok
    testCompileOnly libs.lombok
    testImplementation (libs.springBootStarterTest){
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
    testImplementation (platform( libs.junitBillOfMaterial ))
    testImplementation libs.junitJupiter
    testImplementation libs.reactorTest

    testFixturesImplementation libs.reactorTest
    testFixturesImplementation libs.springBootStarterDataR2dbc
    testFixturesImplementation libs.jakartaPersistenceApi
}