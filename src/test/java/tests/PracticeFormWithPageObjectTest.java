package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class PracticeFormWithPageObjectTest extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void successfulRegistrationTest() {

        registrationPage.
                openPage().
                setFirstName(testData.firstName).
                setLastName(testData.lastName).
                setUserEmail(testData.emailAddress).
                setGenderWrapper(testData.gender).
                setUserNumber(testData.mobileNumber).
                setDateOfBirth(testData.monthOfBirth,testData.yearOfBirth,testData.dayOfBirth).
                setSubjects(testData.subjects).
                setHobbiesWrapper(testData.hobbies).
                setUploadPicture(testData.image).
                setCurrentAddress(testData.currentAddress).
                setState(testData.state).
                setCity(testData.city).
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name",testData.firstName + " " + testData.lastName).
                checkDataInTable("Student Email",testData.emailAddress).
                checkDataInTable("Gender",testData.gender).
                checkDataInTable("Mobile",testData.mobileNumber).
                checkDataInTable("Date of Birth",testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth).
                checkDataInTable("Subjects",testData.subjects).
                checkDataInTable("Hobbies",testData.hobbies).
                checkDataInTable("Picture",testData.image).
                checkDataInTable("Address", testData.currentAddress).
                checkDataInTable("State and City",testData.state +" " + testData.city);
    }

    @Test
    void successfulRegistrationWithMinimumDataTest() {

        registrationPage.
                openPage().
                setFirstName(testData.firstName).
                setLastName(testData.lastName).
                setGenderWrapper(testData.gender).
                setUserNumber(testData.mobileNumber).
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name",testData.firstName + " " + testData.lastName).
                checkDataInTable("Student Email"," ").
                checkDataInTable("Gender",testData.gender).
                checkDataInTable("Mobile",testData.mobileNumber).
                checkDataInTable("Date of Birth",testData.currentDay).
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
                setFirstName(testData.firstName).
                clickSubmit();

        registrationPage.checkAppearanceOfModalForm();
    }
}
