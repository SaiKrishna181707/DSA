import java.util.Scanner;

public class LC1281_SubtractProductAndSumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println(difference(num));
    }
    static int difference(int num) {
        if (num == 0){
            return 0;
        }
        int product = 1;
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            product = product * rem;
            sum = sum + rem;
        }
        return product - sum;
    }
}

