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
        return genders.get(random.nextInt(genders.size()));
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getDateOfBirth() {
        return faker.date().birthday(18, 65).toString();
    }

    public String getSubjects() {
        List<String> subjects = Arrays.asList("Maths", "Physics", "Chemistry", "Biology", "English", "History", "Computer Science");
        return subjects.get(random.nextInt(subjects.size()));
    }

    public String getHobbies() {
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
        return hobbies.get(random.nextInt(hobbies.size()));
    }

    public String getPicturePath() {
        return "test.png";
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        List<String> states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return states.get(random.nextInt(states.size()));
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

