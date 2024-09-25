package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    @Tag("demoqa")
    void successfullyRegistrationTest() {
        step("Open form", () -> {
                    open("/automation-practice-form");
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('footer').remove()");
                });
        step("Fill form", () -> {
                    $("#firstName").setValue("Ivan");
                    $("#lastName").setValue("Semenov");
                    $("#userEmail").setValue("qa@quru.com");
                    $("#genterWrapper").$(byText("Male")).click();
                    $("#userNumber").setValue("3752955556");
                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__month-select").selectOption("July");
                    $(".react-datepicker__year-select").selectOption("2008");
                    $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
                    $("#subjectsInput").setValue("Maths").pressEnter();
                    $("#subjects-label").click();
                    $("#hobbiesWrapper").$(byText("Sports")).click();
                    $("#uploadPicture").uploadFromClasspath("picture2.jpg");
                    $("#currentAddress").setValue("Minsk");
                    $("#state").click();
                    $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
                    $("#city").click();
                    $("#stateCity-wrapper").$(byText("Agra")).click();
                    $("#submit").click();
                });

        step("Verify results", () -> {
            $(".modal-dialog").shouldBe(appear);
            $("#example-modal-sizes-title-lg ").shouldHave(exactText("Thanks for submitting the form"));

            $(".table-responsive").shouldHave(
                    Condition.text("Student Name Ivan Semenov"),
                    Condition.text("Student Email qa@quru.com"),
                    Condition.text("Gender Male"),
                    Condition.text("Mobile 3752955556"),
                    Condition.text("Subjects Maths"),
                    Condition.text("Hobbies Sports"),
                    Condition.text("Picture picture2.jpg"),
                    Condition.text("Address Minsk"),
                    Condition.text("State and City Uttar Pradesh Agra")
            );
        });
    }
}
