package dream.diamond.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 2015/7/9.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
abstract public class AbstractExternalServerApplication<T> extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getApplicationType());
    }

    abstract protected Class<T> getApplicationType();

}
