public class LC1672_RichestCustomerWealth {

    public static void main(String[] args) {

        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {4, 5, 6}
        };

        int result = maximumWealth(accounts);

        System.out.println("Richest Customer Wealth: " + result);
    }

    static int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int i = 0; i < accounts.length; i++) {

            int rowSum = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                rowSum += accounts[i][j];
            }

            if (rowSum > max) {
                max = rowSum;
            }
        }

        return max;
    }
}