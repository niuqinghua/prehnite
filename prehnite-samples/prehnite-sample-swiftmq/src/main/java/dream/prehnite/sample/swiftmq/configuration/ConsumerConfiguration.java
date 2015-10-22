package dream.prehnite.sample.swiftmq.configuration;

import org.apache.qpid.client.AMQAnyDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;
import java.net.URISyntaxException;

/**
 * Created by niuqinghua on 15/10/22.
 */
@Configuration
@ConditionalOnExpression("${prehnite.swift.mq.consumer.enable:true}")
public class ConsumerConfiguration {

    @Autowired
    private MessageListener sampleMessageListener;

    @Value("${prehnite.swift.mq.queue}")
    private String queueName;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean(name = "consumerDestination")
    public AMQAnyDestination consumerDestination() throws URISyntaxException {
        return new AMQAnyDestination(queueName);
    }

    @Bean
    public DefaultMessageListenerContainer container(AMQAnyDestination consumerDestination) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestination(consumerDestination);
        container.setSessionAcknowledgeMode(2);
        container.setMessageListener(sampleMessageListener);
        return container;
    }

}
