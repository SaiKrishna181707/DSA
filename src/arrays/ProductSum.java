import java.util.Scanner;
public class ProductSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = product(n);
        System.out.println(result);
    }
    public static int product(int n) {
        if (n==1) return 1;
        return (n%10) * product(n/10);
    }
}
