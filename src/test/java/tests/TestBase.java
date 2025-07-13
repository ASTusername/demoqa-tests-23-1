package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setup() {
//        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadTimeout = 60000; // Увеличиваем таймаут
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
