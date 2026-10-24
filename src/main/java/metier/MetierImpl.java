package metier;

import dao.IDao;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Primary here only matters if MetierMultiple (profile "multiple") is also active
@Primary
@Service
public class MetierImpl implements IMetier {

    // Depends only on the abstraction; Spring decides which implementation to inject
    private final IDao dao;

    // Constructor injection: the dependency is mandatory and the field is immutable
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    // Trace to confirm which DAO implementation was actually injected
    @PostConstruct
    public void init() {
        System.out.println("[TRACE] Injected DAO implementation: " + dao.getClass().getSimpleName());
    }

    @Override
    public double calcul() {
        // Simple business rule: double the value
        return dao.getValue() * 2.0;
    }
}
