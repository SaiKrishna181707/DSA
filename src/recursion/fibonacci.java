import java.util.Scanner;

public class fibonacci {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int prev = 0;
        int curr = 1;
        int count = 2;
        while(count <= n){
            int temp = curr;
            curr = curr + prev;
            prev = temp;
            count++;
        }
        System.out.println(curr);
    }
}
