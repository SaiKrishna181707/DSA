package math;

public class LC233 {
    public int countDigitOne(int n) {
        long factor = 1;
        int count = 0;

        while(factor <= n){
            long high = n / (factor * 10);
            long current = (n / factor) % 10;
            long low = n % factor;

            if(current == 0){
                count += (int) (high * factor);
            }else if(current == 1){
                count += (int) (high * factor + low + 1);
            }else{
                count += (int) ((high+1) * factor);
            }

            factor *= 10;
        }
        return count;
    }
}
