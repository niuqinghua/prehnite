package dream.diamond.sample.service.impl;

import org.springframework.stereotype.Service;

import dream.diamond.sample.service.SampleService;

/**
 * Created by niuqinghua on 2015/7/24.
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Override
    public String test() {
        return "test";
    }

}
