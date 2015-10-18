package dream.prehinite.netty.http;

import dream.prehinite.netty.http.server.SampleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 15/10/19.
 */
@Configuration
@ComponentScan(value = {"dream.prehinite"})
@EnableAutoConfiguration
public class SampleApplication implements CommandLineRunner {

    @Autowired
    private SampleServer sampleServer;

    @Override public void run(String... args) throws Exception {
        sampleServer.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
