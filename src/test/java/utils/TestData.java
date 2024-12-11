package utils;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestData {
    private final Faker faker = new Faker();
    private final Random random = new Random();

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        return faker.options().option(genders.toArray(new String[0]));
    }

    public String getPhoneNumber() {
        return faker.number().digits(10);
    }

    public String getDateOfBirthDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String getDateOfBirthMonth() {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        return faker.options().option(months.toArray(new String[0]));
    }

    public String getDateOfBirthYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2010));
    }

    public String getFormattedDateOfBirth() {
        return getDateOfBirthDay() + " " + getDateOfBirthMonth() + "," + getDateOfBirthYear();
    }

    public String getSubjects() {
        List<String> subjects = Arrays.asList("Maths", "Physics", "Chemistry", "Biology", "English", "History", "Computer Science");
        return faker.options().option(subjects.toArray(new String[0]));
    }

    public String getHobbies() {
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
        return faker.options().option(hobbies.toArray(new String[0]));
    }

    public String getPicturePath() {
        return "looool.png";
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        List<String> states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return faker.options().option(states.toArray(new String[0]));
    }

    public String getCity() {
        String state = getState();
        switch (state) {
            case "NCR":
                return Arrays.asList("Delhi", "Gurgaon", "Noida").get(random.nextInt(3));
            case "Uttar Pradesh":
                return Arrays.asList("Agra", "Lucknow", "Merrut").get(random.nextInt(3));
            case "Haryana":
                return Arrays.asList("Karnal", "Panipat").get(random.nextInt(2));
            case "Rajasthan":
                return Arrays.asList("Jaipur", "Jodhpur").get(random.nextInt(2));
            default:
                return "Delhi";
        }
    }
}

