public class LC832_FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end] ^ 1;
                row[end] = temp ^ 1;
                start++;
                end--;
            }
            if (start == end) {
                row[start] ^= 1;
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {
                {0, 1, 1},
                {1, 0, 0},
                {1, 1, 1}
        };
        int[][] result = flipAndInvertImage(image);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}