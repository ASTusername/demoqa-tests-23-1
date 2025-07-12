package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @Test
    void fillFormTest() {
//        open("https://google.com");
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex").pressEnter();
        $("#userEmail").setValue("2@mail.ru").pressEnter();
        $("#currentAddress").setValue("Some street 1").pressEnter();
        $("#permanentAddress").setValue("Another street 1").pressEnter();
        $("#submit").click();

        $("[id=search]").shouldHave(text("Some text"));
    }
}
