import java.util.Scanner;
public class RotateImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix (n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        rotate(matrix);

        System.out.println("Rotated Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {

                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Reverse every row
        for (int row = 0; row < n; row++) {

            int start = 0;
            int end = n - 1;

            while (start < end) {

                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;

                start++;
                end--;
            }
        }
    }
}