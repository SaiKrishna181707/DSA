import java.util.Arrays;

public class MergeSortInPlace {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 1, 4};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {

        // base condition
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        // divide
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        // merge
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];

        int i = start;      // left part
        int j = mid + 1;    // right part
        int k = 0;          // temp pointer

        // compare and fill temp
        while (i <= mid && j <= end) {

            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // remaining left
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // remaining right
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }
}