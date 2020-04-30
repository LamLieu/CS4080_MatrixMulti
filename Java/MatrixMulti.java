import java.util.Random;

public class MatrixMulti {
  public static void main(String[] args) {
    String testType = args[0];

    switch (testType) {
      case "0":
        passByReference();
        break;
      case "1":
        passByValue();
        break;
    }

  }

  private static void passByReference() {
    int matrixLength = 2;

    while (true) {
      int[][] matrix1 = generateNewMatrix(matrixLength);
      int[][] matrix2 = generateNewMatrix(matrixLength);
      final long startTime = System.currentTimeMillis();
      runAlgorithm(matrix1, matrix2);
      final long endTime = System.currentTimeMillis();
      System.out.println("[passByReference] Total execution time (Matrix Size = " + matrixLength
          + " x " + matrixLength + "): " + (endTime - startTime));
      matrixLength *= 2;
    }
  }

  private static void passByValue() {
    int matrixLength = 2;
    int[][] matrix1 = generateNewMatrix(matrixLength);
    int[][] matrix2 = generateNewMatrix(matrixLength);
    final long startTime = System.currentTimeMillis();
    int[][] result = new int[matrix1.length][matrix1.length];
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix1.length; j++) {
        for (int k = 0; k < matrix1.length; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    final long endTime = System.currentTimeMillis();

    System.out.println("[passByValue] Total execution time (Matrix Size = " + matrixLength
        + " x " + matrixLength + "): " + (endTime - startTime));
  }

  private static int[][] generateNewMatrix(int n) {
    Random random = new Random();
    int[][] newMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newMatrix[i][j] = random.nextInt(100) + 1;    // sets random values between 1 and 100
      }
    }
    return newMatrix;
  }

  private static void runAlgorithm(int[][] matrix1, int[][] matrix2) {
    int[][] result = new int[matrix1.length][matrix1.length];
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix1.length; j++) {
        for (int k = 0; k < matrix1.length; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
  }
}
