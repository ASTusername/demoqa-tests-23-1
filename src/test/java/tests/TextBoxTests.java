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
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alex").pressEnter();
        $("#userEmail").setValue("2@mail.ru").pressEnter();
        $("#currentAddress").setValue("Some street 1").pressEnter();
        $("#permanentAddress").setValue("Another street 1").pressEnter();
//        $("#submit").scrollIntoView(true).click();
        $("#submit").click();

        $("#output #name").shouldHave(text("Name:Alex"));
        $("#output #email").shouldHave(text("Email:2@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Current Address :Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Another street 1"));

//        Name:Alex
//
//        Email:2@mail.ru
//
//        Current Address :Some street 1
//
//        Permananet Address :Another street 1
    }
}
