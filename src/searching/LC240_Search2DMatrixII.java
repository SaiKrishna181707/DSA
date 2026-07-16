public class LC240_Search2DMatrixII {
    public static void main(String[] args) {
        boolean ans = searchMatrix(new int[][]{{0,1},{1,1},{1,1}}, 0);
        System.out.println(ans);
    }
        static boolean searchMatrix(int[][] matrix, int target) {
            int row = 0;
            int col =matrix[0].length -1;
            while(row < matrix.length && col >=0){
                if(matrix[row][col] == target) return true;
                else if (matrix[row][col] > target) col--;
                else row ++;
            }
            return false;
        }
    }


