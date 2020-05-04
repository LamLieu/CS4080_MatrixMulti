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
    int matrixLength = 200;

    while (true) {
      int[][] matrix1 = generateNewMatrix(matrixLength);
      int[][] matrix2 = generateNewMatrix(matrixLength);
	  int[][] matrix3 = new int[matrixLength][matrixLength];
	  
      final long startTime = System.currentTimeMillis();
      reference(matrix1, matrix2, matrix3);
      final long endTime = System.currentTimeMillis();
      System.out.println("[passByReference] Total execution time (Matrix Size = " + matrixLength
          + " x " + matrixLength + "): " + (endTime - startTime));
		System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
      matrixLength += 200;
    }
  }

  private static void passByValue() {
    int matrixLength = 200;

    while (true) {
      int[][] matrix1 = generateNewMatrix(matrixLength);
      int[][] matrix2 = generateNewMatrix(matrixLength);
	  int[][] matrix3 = new int[matrixLength][matrixLength];
	  
      final long startTime = System.currentTimeMillis();
      value(matrix1, matrix2, matrix3);
      final long endTime = System.currentTimeMillis();
      System.out.println("[passByValue] Total execution time (Matrix Size = " + matrixLength
          + " x " + matrixLength + "): " + (endTime - startTime));
      System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
      matrixLength += 200;
    }
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

  
  
  private static void reference(int[][] matrix1, int[][] matrix2, int[][] matrix3) {
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix1.length; j++) {
        for (int k = 0; k < matrix1.length; k++) {
          matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
  }
  
   private static void value(int[][] matrix1, int[][] matrix2, int[][] matrix3) {
	int[][] m1 = copyOf(matrix1);
	int[][] m2 = copyOf(matrix2);
	int[][] m3 = copyOf(matrix3);
	
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix1.length; j++) {
        for (int k = 0; k < matrix1.length; k++) {
          m3[i][j] += m1[i][k] * m2[k][j];
        }
      }
    }
  }
  
  private static int[][] copyOf(int[][] m) {
	  int[][] toReturn = new int[m.length][m.length];
	  for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m.length; j++) {
			toReturn[i][j] = m[i][j];
		}
	}
	return toReturn;
  }
}
