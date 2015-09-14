package dream.prehnite.component.swiftmq;

import org.apache.qpid.client.AMQConnectionFactory;
import org.apache.qpid.url.URLSyntaxException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by niuqinghua on 15/9/14.
 */
@Configuration
@EnableConfigurationProperties(SwiftMQProperties.class)
public class SwiftMQAutoConfiguration {

    @Bean(name = "amqConnFactory")
    @ConditionalOnMissingBean(AMQConnectionFactory.class)
    public AMQConnectionFactory amqConnFactoryCreator(SwiftMQProperties config) throws URLSyntaxException {
        AMQConnectionFactory connectionFactory = new AMQConnectionFactory();
        connectionFactory.setConnectionURLString(config.getConnectionURL());
        return connectionFactory;
    }

    @Bean(name = "cacheConnFactory")
    @ConditionalOnMissingBean(CachingConnectionFactory.class)
    public CachingConnectionFactory cacheConnFactoryCreator(AMQConnectionFactory amqConnectionFactory, SwiftMQProperties config) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(amqConnectionFactory);

        int sessionCacheSize = config.getSessionCacheSize();
        if (sessionCacheSize > 0) {
            cachingConnectionFactory.setSessionCacheSize(sessionCacheSize);
        }

        return cachingConnectionFactory;
    }

    @Bean(name = "jmsTemplate")
    @ConditionalOnMissingBean(JmsTemplate.class)
    public JmsTemplate jmsTemplate(CachingConnectionFactory cacheConnFactory) {
        return new JmsTemplate(cacheConnFactory);
    }

}
