import java.util.Scanner;

public class RecursionExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the index of the fibonacci number : ");
        int n = input.nextInt();
        System.out.println(fib(n));

    }
    static int fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1) + fib (n-2);

    }
}
