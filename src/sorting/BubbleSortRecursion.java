import java.util.Arrays;
import java.util.Scanner;
public class BubbleSortRecursion {
    public static void main(String[] args) {
        int[] arr = {2,7,1,6};
        int size = arr.length;
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the size of array: ");
//        int size = input.nextInt();
//        System.out.print("Enter the elements of the array: ");
//        int[] arr = new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = input.nextInt();
//        }
//        System.out.println("Array Elements: ");
//        for (int i = 0; i < size; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.print(Arrays.toString(Bsr(arr, size,0)));
    }
    static int[] Bsr(int[] arr, int r, int c) {
        if (r == 1){
            return arr;
        }
        if (c < r - 1){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            return Bsr(arr,r,c+1);
        }else{
            return Bsr(arr,r-1,0);
        }
    }
}
