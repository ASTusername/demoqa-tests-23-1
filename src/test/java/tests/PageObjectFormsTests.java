package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PageObjectFormsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("2@mail.ru")
                .setGender("Male")
                .setUserNumber("8903123456")
                .setDateOfBirth("15", "March", "1995")
                .setSubject("History")
                .setSubject("English")
                .setHobby("Sports")
                .setHobby("Reading")
                .uploadPicture("file.png")
                .setCurrentAddress("Some address")
                .setState("NCR")
                .setCity("Delhi")
                .clickButtonSubmit();
        registrationPage.checkResultTableAppear()
                .checkResult("Student Name", "Alex Ivanov")
                .checkResult("Gender", "Male");
    }
}
