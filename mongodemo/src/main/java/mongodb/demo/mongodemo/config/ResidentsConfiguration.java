package mongodb.demo.mongodemo.config;

import mongodb.demo.mongodemo.models.ResidentsFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResidentsConfiguration {
    @Bean
    public ResidentsFactory residentsDtoFactory() {
        return new ResidentsFactory();
    }
}
