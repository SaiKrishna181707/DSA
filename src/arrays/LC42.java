package arrays;

public class LC42 {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length -1;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(start <= end){
            if(leftMax <= rightMax){
                if(height[start] >= leftMax){
                    leftMax = height[start];
                }
                else{
                    water += leftMax - height[start];
                }
                start ++;
            }
            else{
                if(height[end] >= rightMax){
                    rightMax = height[end];
                }
                else{
                    water += rightMax - height[end];
                }
                end --;
            }
        }
        return water;
    }
}
