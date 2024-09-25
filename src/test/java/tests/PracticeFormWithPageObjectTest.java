package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import static io.qameta.allure.Allure.step;


public class PracticeFormWithPageObjectTest extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Tag("demoqa HW")
    @Test
    void successfulRegistrationTest() {
        step("Open form and full", () -> {
                    registrationPage.
                            openPage().
                            setFirstName(testData.firstName).
                            setLastName(testData.lastName).
                            setUserEmail(testData.emailAddress).
                            setGenderWrapper(testData.gender).
                            setUserNumber(testData.mobileNumber).
                            setDateOfBirth(testData.monthOfBirth, testData.yearOfBirth, testData.dayOfBirth).
                            setSubjects(testData.subjects).
                            setHobbiesWrapper(testData.hobbies).
                            setUploadPicture(testData.image).
                            setCurrentAddress(testData.currentAddress).
                            setState(testData.state).
                            setCity(testData.city).
                            clickSubmit();
                });
        step("Verify results", () -> {
            registrationPage.checkTitleInModalForm("Thanks for submitting the form");
            registrationPage.checkDataInTable("Student Name", testData.firstName + " " + testData.lastName).
                    checkDataInTable("Student Email", testData.emailAddress).
                    checkDataInTable("Gender", testData.gender).
                    checkDataInTable("Mobile", testData.mobileNumber).
                    checkDataInTable("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth).
                    checkDataInTable("Subjects", testData.subjects).
                    checkDataInTable("Hobbies", testData.hobbies).
                    checkDataInTable("Picture", testData.image).
                    checkDataInTable("Address", testData.currentAddress).
                    checkDataInTable("State and City", testData.state + " " + testData.city);
        });
    }

    @Tag("demoqa HW")
    @Test
    void successfulRegistrationWithMinimumDataTest() {

        step("Open form and full", () -> {
                    registrationPage.
                            openPage().
                            setFirstName(testData.firstName).
                            setLastName(testData.lastName).
                            setGenderWrapper(testData.gender).
                            setUserNumber(testData.mobileNumber).
                            clickSubmit();
                });

        step("Verify results", () -> {
            registrationPage.checkTitleInModalForm("Thanks for submitting the form");
            registrationPage.checkDataInTable("Student Name", testData.firstName + " " + testData.lastName).
                    checkDataInTable("Student Email", " ").
                    checkDataInTable("Gender", testData.gender).
                    checkDataInTable("Mobile", testData.mobileNumber).
                    checkDataInTable("Date of Birth", testData.currentDay).
                    checkDataInTable("Subjects", " ").
                    checkDataInTable("Hobbies", " ").
                    checkDataInTable("Picture", " ").
                    checkDataInTable("Address", " ").
                    checkDataInTable("State and City", " ");
        });
    }
    @Tag("demoqa HW")
    @Test
    void negativeRegistrationTest() {

        step("Open form and full", () -> {
                    registrationPage.
                            openPage().
                            setFirstName(testData.firstName).
                            clickSubmit();
                });
        step("Verify results", () -> {
            registrationPage.checkAppearanceOfModalForm();
        });
    }
}
