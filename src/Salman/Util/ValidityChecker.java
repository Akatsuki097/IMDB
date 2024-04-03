package Salman.Util;

public class ValidityChecker {
    public static boolean isNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
    }
}
