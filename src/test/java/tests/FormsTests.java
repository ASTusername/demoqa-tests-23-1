package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormsTests extends TestBase {
    @Test
    void studentRegistrationFormTest() {
        File file = new File("src/test/resources/file.png");

        open("/automation-practice-form");
        // можно было проверить заголовок формы
        // можно было скриптами убрать рекламу (баннеры)
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("2@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8903123456");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995"); // selectOption - метод работы с <select>
                                                                                //                                  <option>
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day.react-datepicker__day--015").click();
        $("#subjectsInput").setValue("History").pressEnter(); // это не понятно
        $("#subjectsInput").setValue("English").pressEnter(); // это не понятно
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(file); // или $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("Some address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        /*
        $("#react-select-3-input").setValue("NCR").pressEnter(); // это не понятно
        $("#react-select-4-input").setValue("Delhi").pressEnter(); // это не понятно
        */

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
