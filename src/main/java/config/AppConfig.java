package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// Scan these packages for @Component / @Service / @Configuration classes
@ComponentScan(basePackages = {"dao", "metier", "config"})
// Load external properties (used by DynamicDaoConfig)
@PropertySource("classpath:app.properties")
public class AppConfig {
}
