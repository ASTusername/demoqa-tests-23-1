package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Forms {
    @BeforeAll
    static void setup() {
//        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadTimeout = 60000; // Увеличиваем таймаут
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void studentRegistrationFormTest() {
        File file = new File("src/test/resources/file.png");

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("2@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8903123456");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day.react-datepicker__day--015").click();
        $("#subjectsInput").setValue("History").pressEnter(); // это не понятно
        $("#subjectsInput").setValue("English").pressEnter(); // это не понятно
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Some address");
        $("#react-select-3-input").setValue("NCR").pressEnter(); // это не понятно
        $("#react-select-4-input").setValue("Delhi").pressEnter(); // это не понятно
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Alex Ivanov"),
                text("2@mail.ru"),
                text("Male"),
                text("8903123456"),
                text("15 March,1995"),
                text("History, English"),
                text("Sports, Reading"),
                text("file.png"),
                text("Some address"),
                text("NCR Delhi"));

//        $("#closeLargeModal").shouldBe(Condition.visible).click();
    }
}
