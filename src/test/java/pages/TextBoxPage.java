package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableResult;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    TableResult tableResult = new TableResult();

    public TextBoxPage openPage() {
        open("/text-box");
        deleteBanners();
        return this;
    }

    public void deleteBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }


    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String lastName) {
        currentAddressInput.setValue(lastName);
        return this;
    }
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkDataInOutput(String name, String email, String currentAddress, String permanentAddress) {
        tableResult.checkOutputResult("#name",name);
        tableResult.checkOutputResult("#email",email);
        tableResult.checkOutputResult("#currentAddress", currentAddress);
        tableResult.checkOutputResult("#permanentAddress",permanentAddress);
        return this;
    }
}
