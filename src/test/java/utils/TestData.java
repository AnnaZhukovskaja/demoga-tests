package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        String[] array = {"Male", "Female", "Other"};
        return array[faker.number().numberBetween(0, array.length - 1)];
    }

    public static String getMobileNumber() {
        return faker.number().digits(10);
    }

    public static String getDayOfBirth() {
        String day = String.valueOf(faker.number().numberBetween(0,28));
       return day;
    }
    public static String getMonthOfBirth() {
        String []month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return month[faker.number().numberBetween(0, month.length - 1)];
    }
    public static String getYearOfBirth() {
        String year = String.valueOf(faker.number().numberBetween(1900,2023));
        return year;
    }

    public static String getCurrentDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        Date currentDate = new Date();
        return formatter.format(currentDate);
    }

    public static String getSubjects() {
        String[] array = {"Maths", "Biology", "Computer Science", "Commerce", "Accounting", "Economics"
                , "Social Studies", "History", "Physics"};
        return array[faker.number().numberBetween(0, array.length - 1)];
    }

    public static String getHobbies() {
        String[] array = {"Sports", "Reading", "Music"};
        return array[faker.number().numberBetween(0, array.length - 1)];
    }
    public static String getImage() {
        String[] array = {"picture.jpg", "picture2.jpg", "picture3.jpg", };
        return array[faker.number().numberBetween(0, array.length - 1)];
    }

    public static String getCurrentAddress() {
        return faker.address().streetAddress();
    }

    public static String getState() {
        String[] array = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return array[faker.number().numberBetween(0, array.length - 1)];
    }

    public static String getCity(String state) {
        String city = "";
        String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] arrayUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] arrayHaryana = {"Karnal", "Panipat"};
        String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
        if (state.equals("NCR")) {
            city =  arrayNCR[faker.number().numberBetween(0, arrayNCR.length - 1)];
        } else if (state.equals("Uttar Pradesh")) {
            city = arrayUttarPradesh[faker.number().numberBetween(0, arrayUttarPradesh.length - 1)];
        } else if (state.equals("Haryana")) {
            city = arrayHaryana[faker.number().numberBetween(0, arrayHaryana.length - 1)];
        } else if (state.equals("Rajasthan")) {
            city = arrayRajasthan[faker.number().numberBetween(0, arrayRajasthan.length - 1)];
        }
        return city;
    }
}
