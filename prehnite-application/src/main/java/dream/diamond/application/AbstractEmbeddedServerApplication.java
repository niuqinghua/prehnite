package dream.diamond.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 2015/7/9.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
abstract public class AbstractEmbeddedServerApplication {

    public static ConfigurableApplicationContext run(Object source, String[] args) {
        return SpringApplication.run(source, args);
    }

}