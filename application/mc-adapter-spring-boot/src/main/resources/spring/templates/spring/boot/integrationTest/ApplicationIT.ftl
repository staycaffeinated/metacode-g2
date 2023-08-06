<#include "/common/Copyright.ftl">
package ${project.basePackage};

import ${project.basePackage}.common.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;

class ApplicationTests extends AbstractIntegrationTest {

    @Test
    @SuppressWarnings("java:S2699") // there's nothing to assert
    void contextLoads() {
        // If this test runs without throwing an exception, then SpringBoot started successfully
    }
}
