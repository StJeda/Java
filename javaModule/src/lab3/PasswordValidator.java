package lab3;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d_]{8,}$";

        String[] testStrings = {"C00l_Pass", "SupperPas1", "Cool_pass", "C00l"};

        for (String s : testStrings) {
            if (Pattern.matches(regex, s)) {
                System.out.println(s + " - надійний пароль");
            } else {
                System.out.println(s + " - ненадійний пароль");
            }
        }
    }
}