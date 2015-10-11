package dream.prehnite.component.dozer;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 15/10/11.
 */
@Configuration
@ConditionalOnClass(DozerBeanMapper.class)
public class DozerAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean(name = "dozerBeanMapper")
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }

}
