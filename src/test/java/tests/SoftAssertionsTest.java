package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void pagesShouldHaveSoftAssertions() {
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[name='query-builder-test']").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("Soft assertions"));

    }
    @Test
    void softAssertionsShouldHaveCodeForJUnit5() {
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[name='query-builder-test']").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$("h4.heading-element").get(2).shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}
