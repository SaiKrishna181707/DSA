package greedy;

import java.util.*;
import java.io.*;

class LC135 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] candy = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }
        int result = candyRating(candy);
        System.out.println(result);
    }

    public static int candyRating(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                if (ans[i] <= ans[i + 1]) {
                    ans[i] = ans[i + 1] + 1;
                }
            }
        }
        for (int num : ans) {
            sum += num;
        }
        return sum;
    }
}
