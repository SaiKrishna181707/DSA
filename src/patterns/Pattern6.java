import java.util.Scanner;
public class Pattern6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows you want to enter: ");
        int n = input.nextInt();
        pattern(n);
    }
    static void pattern(int n){
        for (int row = 1; row <= 2 * n -1 ; row++) {
            int spaces = Math.abs(row - n);
            for (int s = 0 ; s < spaces ; s++ ){
                System.out.print(" ");
            }
            int result = row > n ? 2 * n - row : row;
            for (int col = 1; col <= result ; col++) {
                System.out.print( "* " );
            }
            System.out.println();
        }
    }
}
