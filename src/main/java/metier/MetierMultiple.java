package metier;

import dao.IDao;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Advanced case, only registered with the "multiple" profile.
@Service
@Profile("multiple")
public class MetierMultiple implements IMetier {
    private final List<IDao> daos;
    private final Map<String, IDao> daoMap;

    // Spring injects every IDao bean: as a list, and as a map keyed by bean name
    public MetierMultiple(List<IDao> daos, Map<String, IDao> daoMap) {
        this.daos = daos;
        this.daoMap = daoMap;
    }

    @Override
    public double calcul() {
        // Aggregation: sum of the values from all data sources
        return daos.stream().mapToDouble(IDao::getValue).sum();
    }
}
