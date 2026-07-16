import java.util.Scanner;

public class BinetFormula {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the number of fibonacci numbers you want to print  : ");
        int n =  input.nextInt();
        for (int i = 1; i <= n ; i++) {
            System.out.println(fibonacci(i));
        }

    }

    public static int fibonacci(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;   // (1+√5)/2
        double psi = (1 - sqrt5) / 2;   // (1-√5)/2

        return (int) Math.round(
                (Math.pow(phi, n) - Math.pow(psi, n)) / sqrt5
        );
    }
}