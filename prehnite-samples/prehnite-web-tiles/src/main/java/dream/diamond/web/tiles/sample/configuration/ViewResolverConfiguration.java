package dream.diamond.web.tiles.sample.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by niuqinghua on 2015/7/27.
 */
@Configuration
public class ViewResolverConfiguration {

    @Value("${view.prefix:/WEB-INF/views/}")
    private String prefix;

    @Value("${view.suffix:.jsp}")
    private String suffix;

    @Bean(name = "viewResolver")
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(1);
        return tilesViewResolver;
    }

    @Bean(name = "internalResourceViewResolver")
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceviewResolver = new InternalResourceViewResolver();
        internalResourceviewResolver.setPrefix(prefix);
        internalResourceviewResolver.setSuffix(suffix);
        internalResourceviewResolver.setOrder(2);
        return internalResourceviewResolver;
    }

}
