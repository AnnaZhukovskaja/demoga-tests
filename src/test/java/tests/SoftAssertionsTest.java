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
        $(".js-wiki-more-pages-link").click();
        $$("[data-filterable-for='wiki-pages-filter'] li").get(20).$("a").shouldHave(text("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
               "class Tests {\n" +
               "  @Test\n" +
               "  void test() {\n" +
               "    Configuration.assertionMode = SOFT;\n" +
               "    open(\"page.html\");\n" +
               "\n" +
               "    $(\"#first\").should(visible).click();\n" +
               "    $(\"#second\").should(visible).click();\n" +
               "  }\n" +
               "}"));
    }
}
