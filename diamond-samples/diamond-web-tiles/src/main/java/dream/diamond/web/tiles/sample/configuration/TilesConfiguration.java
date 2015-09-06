package dream.diamond.web.tiles.sample.configuration;

import dream.diamond.constants.Separators;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * Created by niuqinghua on 15/8/24.
 */
@Configuration
public class TilesConfiguration {

    private static final String SEPARATOR_SEMICOLON = Separators.SEMICOLON;

    @Value("${tiles.configurer.definitions:/WEB-INF/tiles/tiles-definitions.xml}")
    private String definitions;

    @Bean(name = "tilesConfigurer")
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(definitions.split(SEPARATOR_SEMICOLON));
        tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
        return tilesConfigurer;
    }

}
