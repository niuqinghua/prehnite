package dream.prehnite.component.swiftmq;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by niuqinghua on 15/9/14.
 */
@ConfigurationProperties(prefix = "prehnite.swiftmq")
public class SwiftMQProperties {

    private String url;

    private String userName;

    private String password;

    private String clientId;

    private String virtualHost;

    private String brokerList;

    private String failover;

    private int sessionCacheSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getFailover() {
        return failover;
    }

    public void setFailover(String failover) {
        this.failover = failover;
    }

    public int getSessionCacheSize() {
        return sessionCacheSize;
    }

    public void setSessionCacheSize(int sessionCacheSize) {
        this.sessionCacheSize = sessionCacheSize;
    }

    public String getConnectionURL() {
        if (url != null && !url.isEmpty()) {
            return url;
        }
        return createConnectionURL();
    }

    private String createConnectionURL() {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("amqp://").append(getUserName()).append(":").append(getPassword());
        urlBuilder.append("@").append(getClientId()).append(getVirtualHost()).append("?");
        urlBuilder.append("brokerlist=").append(getBrokerList());
        urlBuilder.append(";failover=").append(getFailover());
        return urlBuilder.toString();
    }

}
