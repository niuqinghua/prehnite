package dream.prehnite.document;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by niuqinghua on 15/8/23.
 */
@Configuration
@EnableSwagger
@EnableAutoConfiguration
public class SwaggerConfiguration {

    public static final List<String> DEFAULT_INCLUDE_PATTERNS = Arrays.asList("/.*");

    public static final String SWAGGER_GROUP = "api";

    @Value("${app.docs:http://localhost:8080}")
    private String docsLocation;

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(new ApiInfo(
                        " API for Diamond framework based project",
                        "This API provides a JSON representation",
                        null,
                        null,
                        null,
                        null
                ))
                .useDefaultResponseMessages(false)
                        //Map the specific URL patterns into Swagger
                .includePatterns("/.*");
    }

}
