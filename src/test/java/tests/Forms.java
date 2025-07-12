package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $("#gender-radio-1").click();
        $("#userNumber").setValue("89031234567");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day react-datepicker__day--015").click();
        $("#subjectsInput").setValue("History").pressEnter(); // это не понятно
        $("#subjectsInput").setValue("English").pressEnter(); // это не понятно
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Some address");
        $("#react-select-3-input").setValue("NCR").pressEnter(); // это не понятно
        $("#react-select-4-input").setValue("Delhi").pressEnter(); // это не понятно


        $("#submit").scrollIntoView(true).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Alex Surname Ivanov"),
                text("2@name.ru"),
                text("Male"),
                text("89031234567"),
                text("15 March,1975"),
                text("History, English"),
                text("Sports, Reading"),
                text("file.png"),
                text("Some address"),
                text("NCR Delhi"));
    }
}
