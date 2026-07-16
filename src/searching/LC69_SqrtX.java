public class LC69_SqrtX {
    public static void main(String[] args) {
        int ans = mySqrt(10);
        System.out.println(ans);
    }
        static int mySqrt(int x) {
            if (x == 0) return 0;

            int start = 1;
            int end = x;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                // Avoid overflow
                if ((long) mid * mid == x) {
                    return mid;
                } else if ((long) mid * mid < x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return end;
        }
}
