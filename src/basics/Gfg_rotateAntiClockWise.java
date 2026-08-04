package basics;

import java.util.*;

public class Gfg_rotateAntiClockWise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) matrix[i][j] = sc.nextInt();
        }
        reverse(matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
    static void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int col = 0; col < n; col++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = matrix[start][col];
                matrix[start][col] = matrix[end][col];
                matrix[end][col] = temp;
                start++;
                end--;
            }
        }
    }
}
