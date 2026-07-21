package greedy;

public class LC55 {
    public boolean canJump(int[] nums) {

        if (nums.length == 1) return true;

        int n = nums.length - 1;
        int required = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < required) {
                required++;
            } else {
                required = 1;
            }
        }
        return nums[0] >= required;
    }
}
