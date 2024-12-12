package utils;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestData {
    private final Faker faker = new Faker();
    private final Random random = new Random();

    // Сохраненные данные для повторного использования
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String dateOfBirthDay;
    private String dateOfBirthMonth;
    private String dateOfBirthYear;
    private String subjects;
    private String hobbies;
    private String picturePath = "looool.png";
    private String address;
    private String selectedState;
    private String selectedCity;

    public String getFirstName() {
        if (firstName == null) {
            firstName = faker.name().firstName();
        }
        return firstName;
    }

    public String getLastName() {
        if (lastName == null) {
            lastName = faker.name().lastName();
        }
        return lastName;
    }

    public String getEmail() {
        if (email == null) {
            email = faker.internet().emailAddress();
        }
        return email;
    }

    public String getGender() {
        if (gender == null) {
            List<String> genders = Arrays.asList("Male", "Female", "Other");
            gender = faker.options().option(genders.toArray(new String[0]));
        }
        return gender;
    }

    public String getPhoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = faker.number().digits(10);
        }
        return phoneNumber;
    }

    public String getDateOfBirthDay() {
        if (dateOfBirthDay == null) {
            dateOfBirthDay = String.format("%02d", faker.number().numberBetween(1, 28));
        }
        return dateOfBirthDay;
    }

    public String getDateOfBirthMonth() {
        if (dateOfBirthMonth == null) {
            List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
            dateOfBirthMonth = faker.options().option(months.toArray(new String[0]));
        }
        return dateOfBirthMonth;
    }

    public String getDateOfBirthYear() {
        if (dateOfBirthYear == null) {
            dateOfBirthYear = String.valueOf(faker.number().numberBetween(1950, 2010));
        }
        return dateOfBirthYear;
    }

    public String getFormattedDateOfBirth() {
        return getDateOfBirthDay() + " " + getDateOfBirthMonth() + "," + getDateOfBirthYear();
    }

    public String getSubjects() {
        if (subjects == null) {
            List<String> subjectList = Arrays.asList("Maths", "Physics", "Chemistry", "Biology", "English", "History", "Computer Science");
            subjects = faker.options().option(subjectList.toArray(new String[0]));
        }
        return subjects;
    }

    public String getHobbies() {
        if (hobbies == null) {
            List<String> hobbyList = Arrays.asList("Sports", "Reading", "Music");
            hobbies = faker.options().option(hobbyList.toArray(new String[0]));
        }
        return hobbies;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getAddress() {
        if (address == null) {
            address = faker.address().fullAddress();
        }
        return address;
    }

    public String getState() {
        if (selectedState == null) {
            List<String> states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
            selectedState = faker.options().option(states.toArray(new String[0]));
        }
        return selectedState;
    }

    public String getCity() {
        if (selectedCity == null) {
            if (selectedState == null) {
                getState(); // Ensure state is selected before city
            }
            selectedCity = switch (selectedState) {
                case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana" -> faker.options().option("Karnal", "Panipat");
                case "Rajasthan" -> faker.options().option("Jaipur", "Jodhpur");
                default -> "Delhi";
            };
        }
        return selectedCity;
    }
}
