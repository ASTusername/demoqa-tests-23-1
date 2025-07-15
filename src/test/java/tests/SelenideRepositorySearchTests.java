package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTests {
    @Test
    void shouldFindSelenideRepositoryAtTheTopTest() {
        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $$(".Box-sc-g0xbh4-0.flszRz").first().$("a").click();
        // проверкаЖ заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
