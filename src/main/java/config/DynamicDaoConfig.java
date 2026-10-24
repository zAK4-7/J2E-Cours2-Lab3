package config;

import dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

// Strategy C: the data source is selected from app.properties (no recompilation needed)
@Configuration
@Profile("!alias")
public class DynamicDaoConfig {

    @Value("${dao.target}")
    private String daoTarget;

    @Bean
    @Primary
    public IDao dynamicDao() {
        return switch (daoTarget) {
            case "dao"     -> new DaoImpl();
            case "dao2"    -> new DaoImpl2();
            case "daoFile" -> new DaoFile();
            case "daoApi"  -> new DaoApi();
            default -> throw new IllegalArgumentException("Unknown DAO target: " + daoTarget);
        };
    }
}
