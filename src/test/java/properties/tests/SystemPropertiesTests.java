package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
        //gradle property_test Dbrowser=opera   -запуск через консоль и установить browser=opera
    }
}
