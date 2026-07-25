package arrays;

import java.util.HashMap;

public class LC525 {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) prefix--;
            if (nums[i] == 1) prefix++;

            if (prefix == 0) {
                max = i + 1;
            }
            if (map.containsKey(prefix)) {
                max = Math.max(i - map.get(prefix), max);
            } else {
                map.put(prefix, i);
            }
        }
        return max;
    }
}
