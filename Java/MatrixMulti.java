import java.util.Random;

public class MatrixMulti {
  public static void main(String[] args) {
    int matrixLength = 2;
    int[][] matrix1;
    int[][] matrix2;

    while (true) {
      matrix1 = generateNewMatrix(matrixLength);
      matrix2 = generateNewMatrix(matrixLength);
      final long startTime = System.currentTimeMillis();
      int[][] result = runAlgorithm(matrix1, matrix2);
      final long endTime = System.currentTimeMillis();
      System.out.println("Total execution time (Matrix Size = " + matrixLength
          + "x " + matrixLength + "): " + (endTime - startTime));
      matrixLength *= 2;
    }
  }

  private static int[][] generateNewMatrix(int n) {
    Random random = new Random();
    int[][] newMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newMatrix[i][j] = random.nextInt(20) + 1;    // sets random values between 1 and 20
      }
    }
    return newMatrix;
  }

  private static int[][] runAlgorithm(int[][] matrix1, int[][] matrix2) {
    int matrixLength = matrix1.length;
    int[][] result = new int[matrixLength][matrixLength];
    for (int i = 0; i < matrixLength; i++) {
      for (int j = 0; j < matrixLength; j++) {
        for (int k = 0; k < matrixLength; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return result;
  }
}
