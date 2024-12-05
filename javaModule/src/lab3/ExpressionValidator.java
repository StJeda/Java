public static void main(String[] args) {
    String regex = "^(?!.*[+\\-*/]{2,})(?!.*[\\+\\-*/]\\s*$)(?!^\\s*[\\+\\-*/])(?=.*\\().*(?=.*\\))([0-9\\+\\-*/()\\s]+)$";
    String[] testStrings = {
            "(3 + 5) - 9 * 4",
            "((3 + 5) - 9 * 4",
            "(3 + 5 * 2",
            "3 + + 4",
            "(5 + (3 * 2))"
    };

    for (String s : testStrings) {
        if (Pattern.matches(regex, s)) {
            System.out.println(s + " - правильний вираз");
        } else {
            System.out.println(s + " - неправильний вираз");
        }
    }
}