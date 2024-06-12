package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {

        open("/text-box");
        $("#userName").setValue("Anna");
        $("#userEmail").setValue("qa@quru.com");
        $("#currentAddress").setValue("Minsk");
        $("#permanentAddress").setValue("Minsk");
        $("#submit").click();

        $("#output #name").shouldHave(text("Anna"));
        $("#output #email").shouldHave(text("qa@quru.com"));
        $("#output #currentAddress").shouldHave(text("Minsk"));
        $("#output #permanentAddress").shouldHave(text("Minsk"));
}
}
