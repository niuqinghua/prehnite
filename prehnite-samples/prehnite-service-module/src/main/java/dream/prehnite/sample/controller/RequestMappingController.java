package dream.prehnite.sample.controller;

import dream.prehnite.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

/**
 * Created by niuqinghua on 15/10/21.
 */
@Controller
@RequestMapping(value = {"/request", "/request.php", "/request.do"})
public class RequestMappingController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return sampleService.test();
    }

}
