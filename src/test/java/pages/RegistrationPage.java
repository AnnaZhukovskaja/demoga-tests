package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalculatorComponents;
import pages.components.TableResult;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement calendarInput = $("#dateOfBirthInput"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            stateWrapper = $("#state"),
            stateCityContainerWrapper = $("#stateCity-wrapper"),
            cityWrapper = $("#city"),
            submitButton = $("#submit"),
            dialogForm = $(".modal-dialog"),
            dialogFormTitle = $("#example-modal-sizes-title-lg ");

    CalculatorComponents calculatorComponents = new CalculatorComponents();
    TableResult tableResult = new TableResult();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        deleteBanners();
        return this;
    }

    public void deleteBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String lastName) {
        userEmailInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String month,String year, String day) {
        calendarInput.click();
        calculatorComponents.setDate(month,year,day);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
       hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateWrapper.click();
        stateCityContainerWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityWrapper.click();
        stateCityContainerWrapper.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkTitleInModalForm(String title) {
        dialogForm.shouldBe(appear);
        dialogFormTitle.shouldHave(exactText(title));
    }

    public RegistrationPage checkDataInTable(String key, String value) {
        tableResult.checkTableResult(key, value);
        return this;
    }

    public void checkAppearanceOfModalForm() {
        dialogForm.shouldNotBe(visible);
    }
}
