package searching;

class GuessGame {

    private int picked = 6; // Change this to test

    public int guess(int num) {
        if (num > picked) return -1;
        if (num < picked) return 1;
        return 0;
    }
}

public class LC374 extends GuessGame {

    public int guessNumber(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {

            int pick = start + (end - start) / 2;

            int hint = guess(pick);

            if (hint == -1) {
                end = pick - 1;
            } else if (hint == 1) {
                start = pick + 1;
            } else {
                return pick;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC374 obj = new LC374();
        System.out.println(obj.guessNumber(10));
    }
}