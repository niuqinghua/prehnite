package dream.prehnite.sample.swiftmq;

import dream.prehnite.application.AbstractEmbeddedServerApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 2015/7/24.
 */
@Configuration
@ComponentScan(value = {"com.lecloud.vod.stone"})
public class SampleApplication extends AbstractEmbeddedServerApplication {

    public static void main(String[] args) {
        run(SampleApplication.class, args);
    }

}
