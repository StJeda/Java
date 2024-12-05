package lab3;

import java.util.regex.Pattern;

public class IPValidator {
    public static void main() {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        String[] testStrings = {"127.0.0.255.0.1", "255.255.255.0", "1300.6.7.8", "abc.def.gha.bcd"};

        for (String s : testStrings) {
            if (Pattern.matches(regex, s)) {
                System.out.println(s + " - правильна IP-адреса");
            } else {
                System.out.println(s + " - неправильна IP-адреса");
            }
        }
    }
}
