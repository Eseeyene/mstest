package mx.gob.imss.mscmovcatalogosriep.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(servers = @Server(url = "/"))
public class OpenApiConfig {
	@Bean
	public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("mssis-test")
                        .description("Microservicio para ...")
                        .version("0.0.1")
                );
    }
}