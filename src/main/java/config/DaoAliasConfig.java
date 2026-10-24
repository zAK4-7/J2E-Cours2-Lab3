package config;

import dao.DaoApi;
import dao.IDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

// Strategy B: alias bean. Change the returned class to switch the data source.
// Only active with the "alias" profile (DynamicDaoConfig is then disabled,
// because only one @Primary IDao may exist).
@Configuration
@Profile("alias")
public class DaoAliasConfig {

    @Bean
    @Primary
    public IDao daoAlias() {
        return new DaoApi();
    }
}
