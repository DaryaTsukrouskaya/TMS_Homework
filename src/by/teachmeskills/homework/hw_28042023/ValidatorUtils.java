package by.teachmeskills.homework.hw_28042023;

import by.teachmeskills.homework.hw_28042023.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
    public static void fullNameValidation(String fullName) throws ValidationException {
        Pattern pattern = Pattern.compile("^[A-Z1-9]{1}[a-z]+\s[A-Z]{1}[a-z]+\s[A-Z]{1}[a-z]+$");
        Matcher matcher = pattern.matcher(fullName);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect full name data!");
        }
    }

    public static void positionValidation(String position) throws ValidationException {
        Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]+[\s-\\-]*[a-z]*$");
        Matcher matcher = pattern.matcher(position);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect position data!");
        }
    }

    public static void departmentValidation(String department) throws ValidationException {
        Pattern pattern = Pattern.compile("^[0-9]*[\s-\\-]*[a-zA-Z]+\s*[a-z]*$");
        Matcher matcher = pattern.matcher(department);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect department data!");
        }
    }

    public static void workExperienceValidation(String workExp) throws ValidationException {
        Pattern pattern = Pattern.compile("^[0-9]+\s+[a-z]+$");
        Matcher matcher = pattern.matcher(workExp);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect work-experience data!");
        }
    }


}
