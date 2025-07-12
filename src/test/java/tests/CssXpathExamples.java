package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {

    void cssXpath() {
        // <inpur type="email" class="inputtest login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1"); // или так
        $(by("data-testid", "email")).setValue("1"); // или так

        // <inpur type="email" class="inputtest login_form_input_box" name="email" id="email">
        $("#email").setValue("2@mail.ru"); // так короче
        $("[id=email]").setValue("2@mail.ru"); // или так

        // <inpur type="email" class="inputtest login_form_input_box" name="email">
        $("[name=email]").setValue("2@mail.ru");

        // <inpur type="email" class="inputtest login_form_input_box">
        $(".inputtest.login_form_input_box").setValue("word"); // так короче
        $(".login_form_input_box").setValue("word"); // или так еще короче
        $("[class=inputtest][class=login_form_input_box]").setValue("word");
        $("input.inputtest.login_form_input_box").setValue("word"); // здесь еще указали тип элемента

//        <div class="inputtest">
//            <inpur type="email" class="login_form_input_box">
//        </div>
        $(".inputtest .login_form_input_box").setValue("word"); // пробел между классами
        $(".inputtest").$(".login_form_input_box").setValue("word"); // или так

//        <div>Hello, bro!</div>
        $(byText("Hello, bro!"));
        $(withText("llo, br"));
    }

}
