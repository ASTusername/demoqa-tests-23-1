package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
//    public static final String firstName = "Alex",
//            lastName = "Ivanov";

    static Faker faker = new Faker(new Locale("ru"));

    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
}
