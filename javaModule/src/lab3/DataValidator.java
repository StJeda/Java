package lab3;

import java.util.regex.*;

public class DataValidator {
    public static void main() {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(20|21|22|23|24|25|26|27|28|29|30|31)\\d{2}$";

        String[] testStrings = {"29/02/2000", "30/04/2003", "01/01/2003", "29/02/2001", "30-04-2003", "1/1/1899"};

        for (String s : testStrings) {
            if (Pattern.matches(regex, s)) {
                System.out.println(s + " - правильна дата");
            } else {
                System.out.println(s + " - неправильна дата");
            }
        }
    }
}

