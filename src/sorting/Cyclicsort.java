import java.util.Arrays;

public class Cyclicsort {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void insertionSort(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1 ;
            if(correct != i){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int i, int correct){
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] =temp;
    }
}
