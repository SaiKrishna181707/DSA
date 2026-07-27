package greedy;

import java.io.*;
import java.util.*;


public class infos2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] stalls = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stalls[i] = Integer.parseInt(st.nextToken());
        }
        int[] generator = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            generator[i] = Integer.parseInt(st.nextToken());
        }
        int ans = possibleStalls(stalls, generator);
        System.out.println(ans);
    }
    public static int possibleStalls(int[] stalls, int[] generator) {
        Arrays.sort(generator);
        Arrays.sort(stalls);

        int left = 0;
        int count = 0;
        int right = 0;

        while (left < stalls.length && right < generator.length) {
            if (generator[right] >= stalls[left]) {
                count++;
                left++;
            }
            right++;
        }
        return count;
    }
}
