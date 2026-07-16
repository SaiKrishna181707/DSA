public class MaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int answer = max(arr);
        System.out.println(answer);
    }

    static int max(int[][] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int maximum = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > maximum) {
                    maximum = arr[row][col];
                }
            }
        }
        return maximum;

    }
}

