package dream.prehnite.sample.swiftmq.service;

import com.google.gson.Gson;
import dream.prehnite.sample.swiftmq.mq.GpcCacheMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/13.
 */
@Service("messageService")
public class MessageService {

    @Autowired
    private Gson gson;

    @Autowired
    private JmsTemplate producerJmsTemplate;

    public GpcCacheMessage sendMsg() {
        GpcCacheMessage message = new GpcCacheMessage();
        message.setId("123");
        message.setType("video");
        String messageToBeSent = gson.toJson(message);
        producerJmsTemplate.convertAndSend(messageToBeSent);
        return message;
    }

}
