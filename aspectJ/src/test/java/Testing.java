import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.aspects.GreetingAspect;
import ru.itis.inform.service.GreetingService;

import static org.junit.Assert.assertTrue;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
public class Testing {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test-aspectj.xml");
    private GreetingService greetingService;
    @Test
    public void testAnnotationService() {
        greetingService = (GreetingService) applicationContext.getBean("greetingService");
        assertTrue(greetingService.sayHello().contains(GreetingService.HELLO_FROM_GREETING_SERVICE));
        assertTrue(greetingService.sayHello().length()>GreetingService.HELLO_FROM_GREETING_SERVICE.length());
    }
}
