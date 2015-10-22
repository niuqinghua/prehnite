package dream.prehnite.sample.swiftmq.mq;

/**
 * Created by niuqinghua on 15/8/31.
 */
public class GpcCacheMessage {

    private String type;

    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GpcCacheMessage{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
