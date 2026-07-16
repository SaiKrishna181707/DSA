import java.util.Arrays;
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }
        // modify


        arr[2] = 36;
        System.out.println(Arrays.toString(arr));
    }
}
