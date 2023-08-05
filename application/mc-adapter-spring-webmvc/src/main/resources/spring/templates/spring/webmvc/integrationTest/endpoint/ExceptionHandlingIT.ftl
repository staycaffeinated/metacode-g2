<#include "/common/Copyright.ftl">
package ${endpoint.packageName};

<#if endpoint.isWithPostgres() && endpoint.isWithTestContainers()>
import ${endpoint.basePackage}.config.ContainerConfiguration;
import ${endpoint.basePackage}.database.RegisterDatabaseProperties;
</#if>
import ${endpoint.basePackage}.domain.${endpoint.entityName};
import ${endpoint.basePackage}.domain.${endpoint.entityName}TestFixtures;
import ${endpoint.basePackage}.math.SecureRandomSeries;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
<#if endpoint.isWithPostgres() && endpoint.isWithTestContainers()>
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
</#if>
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
<#if endpoint.isWithPostgres() && endpoint.isWithTestContainers()>
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
</#if>

/**
 * Verify exception handling
 */
<#if endpoint.isWithPostgres() && endpoint.isWithTestContainers()>
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@Import(ContainerConfiguration.class)
@Testcontainers
class ${endpoint.entityName}ExceptionHandlingIT implements RegisterDatabaseProperties {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
<#else>
@ExtendWith(SpringExtension.class)
class ${endpoint.entityName}ExceptionHandlingIT implements RegisterDatabaseProperties {
</#if>
    @MockBean
    private ${endpoint.entityName}Service ${endpoint.entityVarName}Service;

    final SecureRandomSeries randomSeries = new SecureRandomSeries();

    @Nested
    class ExceptionTests {

        @Test
        void shouldNotReturnStackTrace() throws Exception {
            // given
            given( ${endpoint.entityVarName}Service.find${endpoint.entityName}ByResourceId(any(String.class))).willThrow(new RuntimeException("Boom!"));
            given( ${endpoint.entityVarName}Service.update${endpoint.entityName}(any(${endpoint.entityName}.class))).willThrow(new RuntimeException("Bad data"));

            ${endpoint.pojoName} payload = ${endpoint.pojoName}.builder().resourceId(randomSeries.nextResourceId()).text("update me").build();

            // when/then
            mockMvc.perform(post("${endpoint.basePath}")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(payload)))
                    .andExpect(jsonPath("$.stackTrace").doesNotExist())
                    .andExpect(jsonPath("$.trace").doesNotExist())
                    .andDo((print()))
                    .andReturn();
        }
    }
}
