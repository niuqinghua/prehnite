package dream.prehnite.component.swiftmq;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by niuqinghua on 15/9/14.
 */
@ConfigurationProperties(prefix = "prehnite.swiftmq")
public class SwiftMQProperties {

    private String url;

    private Integer sessionCacheSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSessionCacheSize() {
        return sessionCacheSize;
    }

    public void setSessionCacheSize(Integer sessionCacheSize) {
        this.sessionCacheSize = sessionCacheSize;
    }
}
