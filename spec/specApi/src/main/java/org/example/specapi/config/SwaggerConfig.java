package org.example.specapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpecAPI Documentation")
                        .version("1.0.0")
                        .description("API documentation for SpecAPI")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpecAPI Wiki Documentation")
                        .url("https://example.com/wiki"))
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Local Server"))
                .addServersItem(new Server()
                        .url("https://api.example.com")
                        .description("Production Server"));
    }
}
