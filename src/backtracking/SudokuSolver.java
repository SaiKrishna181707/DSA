import java.util.Arrays;
class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'9', '.', '1',   '.', '4', '5',   '.', '.', '.'},
                {'.', '.', '.',   '2', '.', '.',   '9', '1', '.'},
                {'7', '.', '.',   '.', '.', '8',   '3', '.', '.'},

                {'8', '1', '.',   '4', '2', '9',   '.', '.', '7'},
                {'.', '.', '.',   '.', '.', '.',   '.', '.', '.'},
                {'3', '.', '.',   '8', '7', '6',   '.', '9', '5'},

                {'.', '.', '6',   '7', '.', '.',   '.', '.', '3'},
                {'.', '4', '7',   '.', '.', '3',   '.', '.', '.'},
                {'.', '.', '.',   '6', '9', '.',   '4', '.', '1'}
        };
        boolean solved = solve(board);
        if (solved) {
            for (char[] arr : board) {
                System.out.println(Arrays.toString(arr));
            }
        } else {
            System.out.println("invalid input");
        }
    }
    static boolean solve ( char[][] board){
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        for (char num = '1'; num <= '9'; num++) {
                            if (isSafe(board,row,col,num)) {
                                board[row][col] = num;
                                if (solve(board)) {
                                    return true;
                                }
                                board[row][col] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        static boolean isSafe ( char[][] board, int row, int col, char num){
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == num) return false;
                if (board[i][col] == num) return false;
            }
            int startcol = col - col % 3;
            int startrow = row - row % 3;
            for (int i = startrow; i < startrow + 3; i++) {
                for (int j = startcol; j < startcol + 3; j++) {
                    if (board[i][j] == num) return false;
                }
            }
            return true;
        }
    }