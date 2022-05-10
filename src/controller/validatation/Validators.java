package controller.validatation;

public class Validators {


    public static boolean validateNotEmpty(String string) {
        return !string.isBlank();
    }


    public static boolean validateEmail(String email) {
        return validateNotEmpty(email) && email.contains("@");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return validateNotEmpty(phoneNumber) && phoneNumber.chars().allMatch(Character::isDigit);
    }

}

