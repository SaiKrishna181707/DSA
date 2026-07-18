package sorting;

public class RadixSort {

    static void radixSort(int[] arr) {

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    static void countSort(int[] arr, int exp) {

        int n = arr.length;

        int[] output = new int[n];

        int[] count = new int[10];

        // Frequency
        for (int j : arr) {
            int digit = (j / exp) % 10;
            count[digit]++;
        }

        // Prefix sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output from right to left (stability)
        for (int i = n - 1; i >= 0; i--) {

            int digit = (arr[i] / exp) % 10;

            output[count[digit] - 1] = arr[i];

            count[digit]--;
        }

        // Copy back
        System.arraycopy(output, 0, arr, 0, n);
    }

    static int getMax(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max)
                max = num;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(arr);

        for (int num : arr)
            System.out.print(num + " ");
    }
}