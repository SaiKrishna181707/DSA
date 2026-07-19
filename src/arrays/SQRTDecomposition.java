package arrays;

public class SQRTDecomposition {

    static int query(int[] blocks, int[] arr, int sqrt, int l, int r) {

        int ans = 0;

        while (l <= r && l % sqrt != 0) {
            ans += arr[l];
            l++;
        }

        while (l + sqrt - 1 <= r) {
            ans += blocks[l / sqrt];
            l += sqrt;
        }

        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    static void update(int[] arr, int[] blocks, int sqrt, int index, int value) {

        int blockNumber = index / sqrt;

        blocks[blockNumber] += value - arr[index];

        arr[index] = value;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int n = arr.length;
        int sqrt = (int)Math.sqrt(n);

        int[] blocks = new int[sqrt + 1];

        int blockIndex = -1;

        for(int i = 0; i < n; i++) {

            if(i % sqrt == 0)
                blockIndex++;

            blocks[blockIndex] += arr[i];
        }

        System.out.println(query(blocks, arr, sqrt, 2, 7)); // 33

        update(arr, blocks, sqrt, 4, 20);

        System.out.println(query(blocks, arr, sqrt, 2, 7)); // 48
    }
}