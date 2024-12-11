package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            stateDropdown = $("#stateCity-wrapper"),
            cityField = $("#city"),
            cityDropdown = $("#stateCity-wrapper"),
            submitBtn = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }


    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String dateOfBirth) {
        dateOfBirthInput.setValue(dateOfBirth).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressTab();
        return this;
    }

    public RegistrationPage uploadPicture(String picturePath) {
        imageUpload.uploadFromClasspath(picturePath);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateDropdown.click();
        $x("//div[text()='" + state + "']").click();
        cityDropdown.click();
        $x("//div[text()='" + city + "']").click();
        return this;
    }

    public RegistrationPage submit() {
        submitBtn.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;


    }
}

