import Helpers.CustomLogger;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    CustomLogger logger = new CustomLogger();

    int[] array = null;

    String menu = "Оберіть спосіб введення масиву:"
            + "\n1. Генерація випадкових чисел"
            + "\n2. Введення з консолі"
            + "\n3. Введення з файлу";

    CustomLogger.logSuccess(menu);

    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            array = generateRandomArray();
            break;
        case 2:
            array = inputArrayFromConsole();
            break;
        case 3:
            array = inputArrayFromFile();
            break;
        default:
            CustomLogger.logError("Невірний вибір!");
            return;
    }

    CustomLogger.logSuccess("Масив: " + Arrays.toString(array));

    try {
        findMinMaxProducts(array);

        sortBetweenMinElements(array);

        countNegativeBeforeMaxPositive(array);

        reverseAndModifyArray(array);

        swapMinToMax(array);
    } catch (Exception e) {
        CustomLogger.logError("Помилка: " + e.getMessage());
    }
}

// 1. Генерація випадкових чисел
private static int[] generateRandomArray() {
    int[] array = new int[50];
    Random rand = new Random();
    for (int i = 0; i < 50; i++) {
        array[i] = rand.nextInt(201) - 100;
    }
    return array;
}

private static int[] inputArrayFromConsole() {
    Scanner scanner = new Scanner(System.in);

    CustomLogger.logSuccess("Введіть кількість елементів масиву: ");

    int size = scanner.nextInt();

    int[] array = new int[size];

    CustomLogger.logSuccess("Введіть елементи масиву: ");

    for (int i = 0; i < size; i++) {
        array[i] = scanner.nextInt();
    }

    return array;
}

private static int[] inputArrayFromFile() {
    Scanner scanner = new Scanner(System.in);

    CustomLogger.logSuccess("Введіть шлях до файлу: ");

    String filePath = scanner.next();

    try {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                list.add(Integer.parseInt(part));
            }
        }
        reader.close();
        return list.stream().mapToInt(i -> i).toArray();
    } catch (FileNotFoundException e) {
        CustomLogger.logError("Файл не знайдений: " + e.getMessage());
    } catch (IOException | NumberFormatException e) {
        CustomLogger.logError("Помилка при читанні файлу: " + e.getMessage());
    }
    return new int[0];
}

private static void findMinMaxProducts(int[] array) {
    Arrays.sort(array);

    int minProduct = array[0] * array[1] * array[2];

    int maxProduct = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];

    CustomLogger.logSuccess("Добуток трьох найменших елементів: " + minProduct);

    CustomLogger.logSuccess("Добуток трьох найбільших елементів: " + maxProduct);
}

private static void sortBetweenMinElements(int[] array) {
    Arrays.sort(array);

    int firstMin = array[0];

    int secondMin = array[1];

    List<Integer> betweenMin = new ArrayList<>();

    for (int j : array) {
        if (j > firstMin && j < secondMin) {
            betweenMin.add(j);
        }
    }

    if (betweenMin.size() > 7) {
        int sum = 0;
        for (int num : betweenMin) {
            sum += num;
        }

        // Перевірка умови
        if (sum > 2 * array[array.length - 1]) {
            Collections.sort(betweenMin);
            CustomLogger.logSuccess("Відсортовані елементи між мінімальними: " + betweenMin);
        }
    }
}

private static void countNegativeBeforeMaxPositive(int[] array) {
    int maxPositive = Integer.MIN_VALUE;

    int negativeCount = 0;

    for (int num : array) {
        if (num > maxPositive) {
            maxPositive = num;
        }
    }

    boolean foundMaxPositive = false;
    for (int num : array) {
        if (num == maxPositive) {
            foundMaxPositive = true;
        }
        if (!foundMaxPositive && num < 0) {
            negativeCount++;
        }
    }

    CustomLogger.logSuccess("Кількість від'ємних елементів до найбільшого додатнього: " + negativeCount);

    if (negativeCount == 0) {
        CustomLogger.logSuccess("Відсортовані елементи після найбільшого додатнього: ");
        Arrays.sort(array);
        CustomLogger.logSuccess(Arrays.toString(array));
    }
}

private static void reverseAndModifyArray(int[] array) {
    int n = array.length;

    for (int i = 0; i < n / 2; i++) {
        int temp = array[i];
        array[i] = array[n - i - 1];
        array[n - i - 1] = temp;
    }

    Arrays.sort(array, 0, n / 2);
    for (int i = 0; i < n / 2 / 2; i++) {
        int temp = array[i];
        array[i] = array[n / 2 - i - 1];
        array[n / 2 - i - 1] = temp;
    }

    int minFirstHalf = array[0];

    for (int i = n / 2; i < n; i++) {
        array[i] -= minFirstHalf;
    }

    CustomLogger.logSuccess("Модифікований масив: " + Arrays.toString(array));
}

private static void swapMinToMax(int[] array) {
    int maxPositive = Integer.MIN_VALUE;
    int minNegative = Integer.MAX_VALUE;
    int maxPosIndex = -1;
    int minNegIndex = -1;

    for (int i = 0; i < array.length; i++) {
        if (array[i] > 0 && array[i] > maxPositive) {
            maxPositive = array[i];
            maxPosIndex = i;
        }
        if (array[i] < 0 && array[i] < minNegative) {
            minNegative = array[i];
            minNegIndex = i;
        }
    }

    if (maxPosIndex != -1 && minNegIndex != -1) {
        int temp = array[maxPosIndex];
        array[maxPosIndex] = array[minNegIndex];
        array[minNegIndex] = temp;
    }

    CustomLogger.logSuccess("Масив після зміни місцями найбільшого додатнього і найменшого від'ємного: " + Arrays.toString(array));
}