<#include "/common/Copyright.ftl">
package ${project.basePackage}.database;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

public interface RegisterDatabaseProperties {

<#if ((project.isWithPostgres()) && (project.isWithTestContainers()))>
    @DynamicPropertySource
    static void registerDatabaseProperties(DynamicPropertyRegistry registry) {
<#if project.schema?has_content>
        // Be aware that calling testContainer.getJdbcUrl returns a URL that starts
        // something like "jdbc:postgresql://localhost...etc...".
        // The URL needs to start with "jdbc:tc:postgresql", The 'tc' between 'jdbc' and
        // 'postgres' is the hint to the driver that the TestContainer handles the URL,
        // not the typical runtime JDCB driver.

        final String initFunction = RegisterDatabaseProperties.class.getName() + "::initFunction";
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:15.1-alpine:///public?TC_INITFUNCTION=" + initFunction);
<#else>
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:15.1-alpine:///public");
</#if>
        // If the tables need to be part of a schema, see the comments
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:15.1-alpine:///public");
        registry.add("spring.datasource.driver-class-name", () -> "org.testcontainers.jdbc.ContainerDatabaseDriver");
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.PostgreSQLDialect");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.show-sql", () -> "true");
        registry.add("spring.jpa.properties.hibernate.format_sql", () -> "true");
    }
<#else>
    <#-- Define H2 database properties -->
    @DynamicPropertySource
    static void registerDatabaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        registry.add("spring.datasource.driver-class-name", () -> "org.h2.Driver");
        registry.add("spring.datasource.initialization-mode", () -> "embedded");
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.H2Dialect");
        registry.add("spring.jpa.properties.hibernate.id.new_generator_mappings", () -> "false");

        // The username and password here must match the username and password in the
        // src/test/resources/application-test.yaml.  Otherwise, you will see
        // "org.h2.jdbc.JdbcSQLInvalidAuthorizationSpecException: Wrong user name or password"
        registry.add("spring.datasource.username", () -> "sa");
        registry.add("spring.datasource.password", () -> "password");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.show-sql", () -> "true");
        registry.add("spring.jpa.properties.hibernate.format_sql", () -> "true");
    }
</#if>


<#if project.schema?has_content>
    /**
    * This method illustrates how to add a schema and tables to test containers.
    * If your tables need to be in a schema, this method will create the schema and
    * tables for you. Hibernate does not automagically create tables or schemas
    * when a schema is used (at least, not when using TestContainers).
    */
    static void initFunction(java.sql.Connection connection) {
        // This contains example DDL statements; the statements DO need to be modified to match your requirements.
        // The statements forgo the `if not exists` clause since we know these objects do not
        // exist in the temporary database of the container.
        final String createSchema = "create schema ${project.schema}";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createSchema);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }
</#if>

}