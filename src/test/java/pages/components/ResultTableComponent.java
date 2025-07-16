package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final SelenideElement modalWindow = $(".modal-dialog"),
            resultTable = $(".table-responsive");

    public void checkResultTableAppear() {
        modalWindow.should(appear);
    }

    public void checkResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
    }
}
