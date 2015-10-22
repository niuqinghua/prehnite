package dream.prehnite.sample.swiftmq.controller;

import dream.prehnite.sample.swiftmq.mq.GpcCacheMessage;
import dream.prehnite.sample.swiftmq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuqinghua on 15/10/13.
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/send")
    public GpcCacheMessage send() {
        return messageService.sendMsg();
    }

}
