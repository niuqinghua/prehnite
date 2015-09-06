package dream.diamond.sample.controller;

import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dream.diamond.sample.service.SampleService;

/**
 * Created by niuqinghua on 2015/7/24.
 */
@RestController
@RequestMapping(value = "/sample")
@Api(value = "sample", description = "sample API")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return sampleService.test();
    }

}
