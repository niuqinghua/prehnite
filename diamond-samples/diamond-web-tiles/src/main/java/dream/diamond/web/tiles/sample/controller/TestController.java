package dream.diamond.web.tiles.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuqinghua on 15/8/24.
 */
@Controller
@RequestMapping(value = "/test1")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String test1About(Model model) {
        logger.info("About page !");

        return "test1/about";
    }

    @RequestMapping(value = "/test2/about", method = RequestMethod.GET)
    public String test2About(Model model) {
        logger.info("About page !");

        return "test1/test2/about";
    }

}
