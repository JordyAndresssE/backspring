package ec.ups.edu.backspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portafolio Devs - Spring API")
                        .version("1.0.0")
                        .description("API REST para gestión de usuarios y proyectos de programadores")
                        .contact(new Contact()
                                .name("Portafolio Programadores")
                                .email("contacto@portafoliodevs.com")))
                .servers(List.of(
                        new Server()
                                .url("https://backspring-production-72c6.up.railway.app")
                                .description("Servidor de Producción (Railway)"),
                        new Server()
                                .url("http://localhost:8081")
                                .description("Servidor Local")
                ));
    }
}
