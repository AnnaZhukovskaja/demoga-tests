package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.TestData.*;

public class PracticeFormWithPageObjectTest extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = getFirstName();
    String lastName = getLastName();
    String emailAddress = getEmailAddress();
    String currentAddress = getCurrentAddress();
    String gender = getGender();
    String mobileNumber = getMobileNumber();
    String subjects = getSubjects();
    String hobbies = getHobbies();
    String state = getState();
    String city = getCity(state);
    String image = getImage();
    String dayOfBirth = getDayOfBirth();
    String monthOfBirth = getMonthOfBirth();
    String yearOfBirth = getYearOfBirth();
    String currentDay = getCurrentDay();

    @Test
    void successfulRegistrationTest() {

        registrationPage.
                openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setUserEmail(emailAddress).
                setGenderWrapper(gender).
                setUserNumber(mobileNumber).
                setDateOfBirth(monthOfBirth,yearOfBirth,dayOfBirth).
                setSubjects(subjects).
                setHobbiesWrapper(hobbies).
                setUploadPicture(image).
                setCurrentAddress(currentAddress).
                setState(state).
                setCity(city).
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name",firstName + " " + lastName).
                checkDataInTable("Student Email",emailAddress).
                checkDataInTable("Gender",gender).
                checkDataInTable("Mobile",mobileNumber).
                checkDataInTable("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth).
                checkDataInTable("Subjects",subjects).
                checkDataInTable("Hobbies",hobbies).
                checkDataInTable("Picture",image).
                checkDataInTable("Address", currentAddress).
                checkDataInTable("State and City",state +" " + city);
    }

    @Test
    void successfulRegistrationWithMinimumDataTest() {

        registrationPage.
                openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGenderWrapper(gender).
                setUserNumber(mobileNumber).
                clickSubmit();

        registrationPage.checkTitleInModalForm("Thanks for submitting the form");
        registrationPage.checkDataInTable("Student Name",firstName + " " + lastName).
                checkDataInTable("Student Email"," ").
                checkDataInTable("Gender",gender).
                checkDataInTable("Mobile",mobileNumber).
                checkDataInTable("Date of Birth",currentDay).
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
                setFirstName(firstName).
                clickSubmit();

        registrationPage.checkAppearanceOfModalForm();
    }
}
