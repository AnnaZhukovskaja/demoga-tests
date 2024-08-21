package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void successfulFillingFormTest() {

        textBoxPage.openPage().
                setUserName("Anna").
                setUserEmail("qa@quru.com").
                setCurrentAddress("Minsk").
                setPermanentAddress("Grodno").
                clickSubmit();
        textBoxPage.checkDataInOutput("Anna","qa@quru.com"," "," ");//check address
    }
}