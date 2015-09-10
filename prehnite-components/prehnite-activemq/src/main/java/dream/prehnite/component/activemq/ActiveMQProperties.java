package dream.prehnite.component.activemq;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by niuqinghua on 15/9/5.
 */
@ConfigurationProperties(prefix = "diamond.activemq")
public class ActiveMQProperties {

    private String brokerURL;

    public String getBrokerURL() {
        return brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
    }

}
