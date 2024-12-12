package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import utils.TestData;

public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillPracticeFormTest() {
        String firstName = testData.getFirstName();
        String lastName = testData.getLastName();
        String email = testData.getEmail();
        String gender = testData.getGender();
        String phoneNumber = testData.getPhoneNumber();
        String dateOfBirthDay = testData.getDateOfBirthDay();
        String dateOfBirthMonth = testData.getDateOfBirthMonth();
        String dateOfBirthYear = testData.getDateOfBirthYear();
        String formattedDateOfBirth = testData.getFormattedDateOfBirth();
        String subjects = testData.getSubjects();
        String hobbies = testData.getHobbies();
        String picturePath = testData.getPicturePath();
        String address = testData.getAddress();
        String state = testData.getState();
        String city = testData.getCity();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setEmail(testData.getEmail())
                .setGender(testData.getGender())
                .setPhoneNumber(testData.getPhoneNumber())
                .setDateOfBirth(testData.getFormattedDateOfBirth())
                .setSubjects(testData.getSubjects())
                .setHobbies(testData.getHobbies())
                .uploadPicture(testData.getPicturePath())
                .setAddress(testData.getAddress())
                .selectState(testData.getState())
                .selectCity(testData.getCity())
                .submit()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", formattedDateOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picturePath)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
