package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Tag("simple")
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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picturePath)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
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
    @Test
    @Tag("simple")
    void incompleteDatesTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setEmail(testData.getEmail())
                .setGender(testData.getGender())
                .setPhoneNumber(testData.getPhoneNumber())
                .setDateOfBirth(testData.getDateOfBirthDay(), testData.getDateOfBirthMonth(), testData.getDateOfBirthYear())
                .submit()


                .checkResult("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .checkResult("Student Email", testData.getEmail())
                .checkResult("Gender", testData.getGender())
                .checkResult("Mobile", testData.getPhoneNumber())
                .checkResult("Date of Birth", testData.getDateOfBirthDay() + " " + testData.getDateOfBirthMonth() + "," + testData.getDateOfBirthYear());

    }
}
