package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResult {

    public void checkTableResult(String key, String value) {

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }

    public void checkOutputResult(String selenideElement, String value) {

        $(selenideElement).shouldHave(text(value));

    }
}
