package lab2;

import Helpers.CustomLogger;

import java.io.*;
import java.util.*;

public class ArraySecond {

    public static void main() {
        try {
            int[][] matrixA = loadMatrixFromFile();
            if (matrixA == null) return;

            double rowAverageSum = calculateRowAverageSum(matrixA);
            CustomLogger.logSuccess("Сума середніх значень елементів рядків: " + rowAverageSum);

            int[][] matrixB1 = createMatrixBFromMatrixA1(matrixA, rowAverageSum);
            saveMatrixToFile(matrixB1, "matrixB1.txt");
            CustomLogger.logSuccess("Матриця B (заміна елементів під головною діагоналлю) успішно збережена.");

            double minPositiveToMaxNegative = calculateMinPositiveToMaxNegative(matrixA);
            CustomLogger.logSuccess("Відношення мінімального додатного до максимального від'ємного: " + minPositiveToMaxNegative);

            int[][] matrixB2 = createMatrixBFromMatrixA2(matrixA);
            saveMatrixToFile(matrixB2, "matrixB2.txt");
            CustomLogger.logSuccess("Матриця B (перестановка стовпців) успішно збережена.");

            double zeroToNonZeroRatio = calculateZeroToNonZeroRatio(matrixA);
            CustomLogger.logSuccess("Відношення кількості нульових до ненульових елементів: " + zeroToNonZeroRatio);

            int[][] matrixB3 = createMatrixBFromMatrixA3(matrixA);
            saveMatrixToFile(matrixB3, "matrixB3.txt");
            CustomLogger.logSuccess("Матриця B (симетричне відображення) успішно збережена.");

        } catch (Exception e) {
            CustomLogger.logError("Помилка: " + e.getMessage());
        }
    }

    private static int[][] loadMatrixFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\javaModule\\src\\matrixA.txt"));
            List<int[]> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+");
                int[] row = Arrays.stream(values)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                rows.add(row);
            }
            reader.close();
            return rows.toArray(new int[0][0]);
        } catch (FileNotFoundException e) {
            CustomLogger.logError("Файл не знайдений: " + e.getMessage());
        } catch (IOException | NumberFormatException e) {
            CustomLogger.logError("Помилка при читанні файлу: " + e.getMessage());
        }
        return null;
    }

    private static void saveMatrixToFile(int[][] matrix, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int num : row) {
                    writer.write(num + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            CustomLogger.logError("Помилка при записі у файл: " + e.getMessage());
        }
    }

    private static double calculateRowAverageSum(int[][] matrix) {
        double sum = 0;
        for (int[] row : matrix) {
            double rowSum = 0;
            for (int num : row) {
                rowSum += num;
            }
            sum += rowSum / row.length;
        }
        return sum;
    }

    private static int[][] createMatrixBFromMatrixA1(int[][] matrix, double rowAverageSum) {
        int n = matrix.length;
        int[][] matrixB = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    matrixB[i][j] = (int) rowAverageSum;
                } else {
                    matrixB[i][j] = matrix[i][j];
                }
            }
        }
        return matrixB;
    }

    private static double calculateMinPositiveToMaxNegative(int[][] matrix) {
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num > 0 && num < minPositive) {
                    minPositive = num;
                }
                if (num < 0 && num > maxNegative) {
                    maxNegative = num;
                }
            }
        }

        return (minPositive == Integer.MAX_VALUE || maxNegative == Integer.MIN_VALUE) ? 0 : (double) minPositive / maxNegative;
    }

    private static int[][] createMatrixBFromMatrixA2(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixB = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = matrix[i][n - j - 1];
            }
        }
        return matrixB;
    }

    private static double calculateZeroToNonZeroRatio(int[][] matrix) {
        int zeroCount = 0;
        int nonZeroCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    nonZeroCount++;
                }
            }
        }

        return (nonZeroCount == 0) ? 0 : (double) zeroCount / nonZeroCount;
    }

    private static int[][] createMatrixBFromMatrixA3(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixB = new int[n][n];
        int midColumn = n / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < midColumn; j++) {
                matrixB[i][j] = matrix[i][n - j - 1];
                matrixB[i][n - j - 1] = matrix[i][j];
            }
        }

        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                matrixB[i][midColumn] = matrix[i][midColumn];
            }
        }

        return matrixB;
    }
}
