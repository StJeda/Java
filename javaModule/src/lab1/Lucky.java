public static String checkLuckyNumber(int number) {
    if (number < 100000 || number > 999999) {
        return "Шеф, усе втрачено!!!";
    }

    String numberStr = String.valueOf(number);
    int sumFirstThree = numberStr.substring(0, 3).chars().map(Character::getNumericValue).sum();
    int sumLastThree = numberStr.substring(3).chars().map(Character::getNumericValue).sum();

    if (sumFirstThree == sumLastThree) {
        return "Урааааа";
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 6; i++) {
        int digit = Character.getNumericValue(numberStr.charAt(i));
        result.append(switch (i) {
            case 0, 2, 5 -> digit + 1;
            case 1, 3, 4 -> digit / 2;
            default -> digit;
        });
    }
    return result.toString();
}

public static void main() {
    System.out.println(checkLuckyNumber(123321));  // Урааааа
    System.out.println(checkLuckyNumber(987654));  // 9.632313
    System.out.println(checkLuckyNumber(12345));   // Шеф, усе втрачено!!!
}