package searching;

import java.util.Stack;

public class LC85 {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0 ;

        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,longestRectangle(heights));
        }
        return maxArea;
    }
    public int longestRectangle(int[] heights){

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++){

            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight){
                int height = heights[stack.pop()];

                int width;

                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
