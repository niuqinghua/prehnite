package dream.diamon.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dream.diamond.application.AbstractEmbeddedServerApplication;

@Configuration
@ComponentScan(value = {"dream.diamond"})
public class SampleApplication extends AbstractEmbeddedServerApplication {

    public static void main(String[] args) {
        run(SampleApplication.class, args);
    }

}
