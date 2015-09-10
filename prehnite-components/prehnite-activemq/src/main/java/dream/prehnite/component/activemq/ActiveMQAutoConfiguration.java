package dream.prehnite.component.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * Created by niuqinghua on 15/9/5.
 */
@Configuration
@ConditionalOnClass(ActiveMQConnectionFactory.class)
@EnableConfigurationProperties(ActiveMQProperties.class)
public class ActiveMQAutoConfiguration {

    @Bean(name = "activeMQConnectionFactory")
    @ConditionalOnMissingBean(ActiveMQConnectionFactory.class)
    public ActiveMQConnectionFactory activeMQConnectionFactory(ActiveMQProperties config) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(config.getBrokerURL());
        return activeMQConnectionFactory;
    }

    @Bean(name = "pooledConnectionFactory")
    @ConditionalOnMissingBean(PooledConnectionFactory.class)
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        return new PooledConnectionFactory(activeMQConnectionFactory);
    }

    @Bean(name = "connectionFactory")
    @ConditionalOnMissingBean(SingleConnectionFactory.class)
    public ConnectionFactory connectionFactory(PooledConnectionFactory pooledConnectionFactory) {
        return new SingleConnectionFactory(pooledConnectionFactory);
    }

    @Bean(name = "jmsTemplate")
    @ConditionalOnMissingBean(JmsTemplate.class)
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

}
