package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Semenov");
        $("#userEmail").setValue("qa@quru.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("3752955556");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        $("#subjects-label").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Minsk");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg ").shouldHave(exactText("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                Condition.text("Student Name Ivan Semenov"),
                Condition.text("Student Email qa@quru.com"),
                Condition.text("Gender Male"),
                Condition.text("Mobile 3752955556"),
                Condition.text("Date of Birth 02 February,1999"),
                Condition.text("Subjects Maths"),
                Condition.text("Hobbies Sports"),
                Condition.text("Picture picture.jpg"),
                Condition.text("Address Minsk"),
                Condition.text("State and City Uttar Pradesh Agra")
        );
    }
}
