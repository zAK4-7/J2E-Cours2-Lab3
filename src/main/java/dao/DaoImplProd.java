package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// Only registered when the "prod" profile is active
@Component("daoProd")
@Profile("prod")
public class DaoImplProd implements IDao {
    @Override
    public double getValue() {
        System.out.println("[DAO] Reading from the production database (prod profile)");
        return 100.0;
    }
}
