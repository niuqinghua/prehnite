package dream.prehnite.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dream.prehnite.application.AbstractEmbeddedServerApplication;

@Configuration
@ComponentScan(value = {"dream.prehnite"})
public class SampleApplication extends AbstractEmbeddedServerApplication {

    public static void main(String[] args) {
        run(SampleApplication.class, args);
    }

}
