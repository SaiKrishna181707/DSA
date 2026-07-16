import java.util.Arrays;

public class SelectionSortRecursion {
    public static void main(String[] args) {
        int[] arr = {2,7,1,6};
        int size = arr.length;
        Ssr(arr,size,0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void Ssr(int[] arr, int r , int c , int max) {
        if (r==0) return;
        if (c<r) {
            if(arr[c] > arr[max]){
                Ssr(arr,r,c+1,c);
            }
            else{
                Ssr(arr,r,c+1,max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            Ssr(arr,r-1,0,0);
        }

    }
}
