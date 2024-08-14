package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithPageObjectTest extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.
                openPage().
                setFirstName("Ivan").
                setLastName("Ivanov").
                setUserEmail("qa@quru.com").
                setGenderWrapper("Male").
                setUserNumber("3752955556").
                setDateOfBirth("July","2000","25").
                setSubjects("Maths").
                setHobbiesWrapper("Sports").
                setUploadPicture("picture.jpg").
                setCurrentAddress("Minsk").
                setState("Uttar Pradesh").
                setCity("Agra").
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name","Ivan Ivanov").
                checkDataInTable("Student Email","qa@quru.com").
                checkDataInTable("Gender","Male").
                checkDataInTable("Mobile","3752955556").
                checkDataInTable("Date of Birth","25 July,2000").
                checkDataInTable("Subjects","Maths").
                checkDataInTable("Hobbies","Sports").
                checkDataInTable("Picture","picture.jpg").
                checkDataInTable("Address", "Minsk").
                checkDataInTable("State and City","Uttar"+" Pradesh Agra");
    }

    @Test
    void successfulRegistrationWithMinimumDataTest() {

        registrationPage.
                openPage().
                setFirstName("Ivan").
                setLastName("Ivanov").
                setGenderWrapper("Male").
                setUserNumber("3752955556").
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name","Ivan Ivanov").
                checkDataInTable("Student Email"," ").
                checkDataInTable("Gender","Male").
                checkDataInTable("Mobile","3752955556").
                checkDataInTable("Date of Birth","14 August,2024").
                checkDataInTable("Subjects"," ").
                checkDataInTable("Hobbies"," ").
                checkDataInTable("Picture"," ").
                checkDataInTable("Address", " ").
                checkDataInTable("State and City"," ");
    }
    @Test
    void negativeRegistrationTest() {

        registrationPage.
                openPage().
                setFirstName("Ivan").
                clickSubmit();

        registrationPage.checkAppearanceOfModalForm();
    }
}
