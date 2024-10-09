package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Tag("property")
    @Test
    void systemProperties1Test() {
        String browser = System.getProperty("browser","mozilla");
        System.out.println(browser);
        //gradle property_test -Dbrowser=opera   - команда для запуска через консоль и передачи в  browser=opera
        //clean ${TASK} "-Dbrowser=${BROWSER}"      - in jenkins
        //вывод будет: opera

        //gradle property_test   - команда для запуска через консоль без  передачи в  browser=opera
        //вывод будет: mozilla
    }
    @Tag("hello")
    @Test
    void systemProperties2Test() {
        String name = System.getProperty("name","default student");
        String message = format("Hello, %s!", name);
        System.out.println(message);

        //gradle hello_test "-Dname=Olga Smirnova"   - команда для запуска через консоль и передачи в  browser=opera
        //clean ${TASK} "-Dname=${OLGA Smirnova}"      - in jenkins
        //вывод будет: opera

        //gradle hello_test   - команда для запуска через консоль без  передачи в  browser=opera
        //вывод будет: Hello,default student!
    }
}
