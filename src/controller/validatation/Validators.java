package controller.validatation;

public class Validators {

     static final int VALID_PHONE_NUMBER_LENGTH = 8;

    public static boolean validateNotEmpty(String string) {
        return !string.isBlank();
    }

    public static boolean validateEmail(String email) {
        return validateNotEmpty(email) && email.contains("@");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return validateNotEmpty(phoneNumber)
                && phoneNumber.length() >= VALID_PHONE_NUMBER_LENGTH
                && phoneNumber.chars().allMatch(Character::isDigit);
    }
}

