package math;

public class LC231 {
    public boolean isPowerOfTwo(int n) {

      /* if(n <= 0) return false;

        int power = 1;
        while( n/ power >= 1){
            if(n % power != 0){
                return false;
            }
            power *= 2;
        }
        return true;""
        */
        return n > 0 && (n & (n - 1)) == 0;

    }
}
