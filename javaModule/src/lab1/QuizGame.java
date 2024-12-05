public static void main() {
    Scanner scanner = new Scanner(System.in);


    System.out.println("Перевір свої можливості");

    String[] questions = {
            "1. Професор ліг спати о 8 годині, а встав о 9 годині. Скільки годин проспав професор?",
            "2. На двох руках десять пальців. Скільки пальців на 10?",
            "3. Скільки цифр у дюжині?",
            "4. Скільки потрібно зробити розпилів, щоб розпиляти колоду на 12 частин?",
            "5. Лікар зробив три уколи в інтервалі 30 хвилин. скільки часу він витратив?",
            "6. Скільки цифр 9 в інтервалі 1100?",
            "7. Пастух мав 30 овець. Усі, крім однієї, розбіглися. Скільки овець лишилося?"
    };

    int[] correctAnswersArray = {1, 50, 2, 11, 30, 1, 1};

    int correctAnswers = 0;

    for (int i = 0; i < questions.length; i++) {
        System.out.println(questions[i]);
        int userAnswer = scanner.nextInt();

        if (userAnswer == correctAnswersArray[i]) {
            correctAnswers++;
        }
    }

    System.out.println("6. Скільки цифр 9 в інтервалі 1100?");
    if (scanner.nextInt() == 1)
        correctAnswers++;

    System.out.println("7. Пастух мав 30 овець. Усі, крім однієї, розбіглися. Скільки овець лишилося?");
    if (scanner.nextInt() == 1)
        correctAnswers++;

    Map<Integer, String> ranksMap = Map.of(
            7, "Геній",
            6, "Ерудит",
            5, "Нормальний",
            4, "Здібності середні",
            3, "Здібності нижче середнього"
    );

    String rang = ranksMap.getOrDefault(correctAnswers, "Вам треба відпочити!");
    System.out.println(rang);
}

