import java.util.Scanner;

public class LC1351_CountNegativesInSortedMatrix {

    // Your completed method
    public static int countNegatives(int[][] grid) {
        int count = 0;
        int rows = 0;
        int cols = grid[0].length - 1;

        while (rows < grid.length && cols >= 0) {
            if (grid[rows][cols] < 0) {
                // All elements below this one in the column are negative
                count += (grid.length - rows);
                cols--; // Move left
            } else {
                rows++; // Move down
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter the matrix elements (sorted non-increasing in rows/cols):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Call your method and print the result
        int result = countNegatives(grid);
        System.out.println("Total negative numbers: " + result);

        scanner.close();
    }
}