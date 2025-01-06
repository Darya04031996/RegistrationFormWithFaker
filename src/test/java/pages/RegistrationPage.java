package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement imageUpload = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitBtn = $("#submit");



    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Убираем баннер")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполняем имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполняем электронную почту")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Заполняем телефон")
    public RegistrationPage setPhoneNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Выбираем предмет")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressTab();
        return this;
    }
    @Step("Выбираем хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage uploadPicture(String value) {
        imageUpload.uploadFromClasspath(value);
        return this;
    }
    @Step("Заполняем  адрес")
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    @Step("Выбираем штат")
    public RegistrationPage selectState(String value) {
        stateInput.scrollTo();
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Выбираем город")
    public RegistrationPage selectCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Submit'")
    public RegistrationPage submit() {
        submitBtn.click();
        return this;
    }
    @Step("Проерка результатов")
    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }
    @Step("Проверяем, что граница поля электронной почты красного цвета")
    public RegistrationPage verifyUserNumberFieldIsRed() {
        userEmailInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}

