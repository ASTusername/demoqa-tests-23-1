package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void setup() {
//        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadTimeout = 60000; // Увеличиваем таймаут
//        Configuration.pageLoadStrategy = "eager"; // Пробуем стратегию загрузки
    }

    @Test
    void fillFormTest() {
//        open("https://google.com");
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex").pressEnter();
        $("#userEmail").setValue("2@mail.ru").pressEnter();
        $("#currentAddress").setValue("Some street 1").pressEnter();
        $("#permanentAddress").setValue("Another street 1").pressEnter();
//        $("#submit").scrollIntoView(true).click();
        $("#submit").click();

        $("#name").shouldHave(text("Name:Alex"));
    }
}
