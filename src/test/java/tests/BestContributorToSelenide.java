package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void firstContributorTest() {
        open("https://github.com/selenide/selenide");
        $("a[href='/selenide/selenide/graphs/contributors']").closest("div").$$("ul li").first().$("a").hover();
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }
}
