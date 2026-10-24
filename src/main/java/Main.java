import config.AppConfig;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // try-with-resources closes the Spring container automatically
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            IMetier metier = context.getBean(IMetier.class);
            System.out.println("Final result: " + metier.calcul());
        }
    }
}
