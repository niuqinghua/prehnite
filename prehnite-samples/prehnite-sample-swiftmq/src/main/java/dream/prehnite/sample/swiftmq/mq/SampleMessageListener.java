package dream.prehnite.sample.swiftmq.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * Created by niuqinghua on 15/9/18.
 */
@Component("sampleMessageListener")
public class SampleMessageListener implements MessageListener {

    public static final Logger logger = LoggerFactory.getLogger(SampleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            logger.info("message received: {}", text);
            GpcCacheMessage gpcCacheMessage = parseMessage(text);
            logger.info("message parsed: {}", gpcCacheMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GpcCacheMessage parseMessage(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, GpcCacheMessage.class);
        } catch (Exception e) {
            logger.error("message received: {}", message, e);
            throw e;
        }
    }

}
