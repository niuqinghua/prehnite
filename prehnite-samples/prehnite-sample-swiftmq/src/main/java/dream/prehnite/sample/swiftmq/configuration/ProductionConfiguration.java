package dream.prehnite.sample.swiftmq.configuration;

import org.apache.qpid.client.AMQAnyDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.net.URISyntaxException;

/**
 * Created by niuqinghua on 15/9/18.
 */
@Configuration
public class ProductionConfiguration {

    @Value("${prehnite.swift.mq.binding}")
    private String biding;

    @Value("${prehnite.swift.mq.exchange}")
    private String exchange;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean(name = "produceDestination")
    public AMQAnyDestination produceDestination() throws URISyntaxException {
        return new AMQAnyDestination(exchange + "/" + biding);
    }

    @Bean(name = "producerJmsTemplate")
    public JmsTemplate producerJmsTemplate(AMQAnyDestination produceDestination) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setDefaultDestination(produceDestination);
        return jmsTemplate;
    }

}
