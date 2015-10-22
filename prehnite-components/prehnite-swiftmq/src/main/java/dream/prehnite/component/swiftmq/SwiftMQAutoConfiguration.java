package dream.prehnite.component.swiftmq;

import org.apache.qpid.client.AMQConnectionFactory;
import org.apache.qpid.url.URLSyntaxException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * Created by niuqinghua on 15/9/14.
 */
@Configuration
@EnableConfigurationProperties(SwiftMQProperties.class)
public class SwiftMQAutoConfiguration {

    @Bean(name = "connectionFactory")
    @ConditionalOnMissingBean(ConnectionFactory.class)
    public ConnectionFactory amqConnFactory(SwiftMQProperties config) throws URLSyntaxException {
        return new AMQConnectionFactory(config.getUrl());
    }

    @Bean(name = "jmsTemplate")
    @ConditionalOnMissingBean(JmsTemplate.class)
    @ConditionalOnClass(value = {JmsTemplate.class, ConnectionFactory.class})
    public JmsTemplate amqJmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

}
