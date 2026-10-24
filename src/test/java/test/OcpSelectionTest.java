package test;

import static org.junit.Assert.assertEquals;

import config.AppConfig;
import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OcpSelectionTest {

    @Test
    public void testDefaultDaoSelection() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            IMetier metier = context.getBean(IMetier.class);

            // With dao.target=dao the result must be 100.0 * 2 = 200.0
            assertEquals(200.0, metier.calcul(), 0.001);
        }
    }
}
