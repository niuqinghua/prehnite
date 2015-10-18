package dream.prehnite.configuration;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by niuqinghua on 2015/7/9.
 */
@Configuration
public class UTF8EncodingConfiguration {

    @Bean(name="characterEncodingFilter")
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

}
