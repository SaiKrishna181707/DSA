import java.util.Scanner;

public class numbercount {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        System.out.print("enter the digit you want to count: ");
        int digit = input.nextInt();
        int count = 0;
        while(num > 0){
            int rem = num % 10;
            num = num / 10;
            if (rem == digit){
                count++;
            }
        }
        System.out.println("the digit occured " + count + " times");
    }
}
