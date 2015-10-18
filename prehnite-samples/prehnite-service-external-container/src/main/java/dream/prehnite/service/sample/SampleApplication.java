package dream.prehnite.service.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dream.prehnite.application.AbstractExternalServerApplication;

/**
 * Created by niuqinghua on 2015/7/24.
 */
@Configuration
@ComponentScan(value = {"dream.prehnite"})
public class SampleApplication extends AbstractExternalServerApplication<SampleApplication> {

    private static final Class<SampleApplication> sampleApplicationClass = SampleApplication.class;

    @Override
    protected Class<SampleApplication> getApplicationType() {
        return sampleApplicationClass;
    }

    public static void main(String[] args) {
        SpringApplication.run(sampleApplicationClass, args);
    }

}
