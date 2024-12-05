package lab3;

import java.util.regex.Pattern;

public class ColorValidator {
    public static void main() {
        String regex = "^#([0-9A-Fa-f]{6})$";
        String[] testStrings = {"#FFFFFF", "#FF3421", "#00ff00", "232323", "f#fddee", "#fd2"};

        for (String s : testStrings) {
            if (Pattern.matches(regex, s)) {
                System.out.println(s + " - правильний ідентифікатор кольору");
            } else {
                System.out.println(s + " - неправильний ідентифікатор кольору");
            }
        }
    }
}
