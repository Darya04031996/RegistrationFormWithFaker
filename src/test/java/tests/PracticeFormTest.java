package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import utils.TestData;

public class PracticeFormTest extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setEmail(testData.getEmail())
                .setGender(testData.getGender())
                .setPhoneNumber(testData.getPhoneNumber())
                .setDateOfBirth(testData.getDateOfBirth())
                .setSubjects(testData.getSubjects())
                .setHobbies(testData.getHobbies())
                .uploadPicture(testData.getPicturePath())
                .setAddress(testData.getAddress())
                .setStateAndCity(testData.getState(), testData.getCity())
                .submit()
                .checkResult("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .checkResult("Student Email", testData.getEmail())
                .checkResult("Gender", testData.getGender())
                .checkResult("Mobile", testData.getPhoneNumber())
                .checkResult("Date of Birth", testData.getDateOfBirth())
                .checkResult("Subjects", testData.getSubjects())
                .checkResult("Hobbies", testData.getHobbies())
                .checkResult("Picture", testData.getPicturePath())
                .checkResult("Address", testData.getAddress())
                .checkResult("State and City", testData.getState() + " " + testData.getCity());
    }
}