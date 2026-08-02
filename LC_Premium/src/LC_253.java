/*
Given an array of meeting time intervals [intervals] where intervals[i] = [start i, end i], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

*/


import java.util.*;
public class LC_253 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            matrix[i][0] = input.nextInt();
            matrix[i][1] = input.nextInt();
        }
        System.out.println(meetingsRoom(matrix));
        input.close();
    }
    static int meetingsRoom(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        Arrays.sort(matrix,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(matrix[0][1]);
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.offer(matrix[i][1]);
        }
        return pq.size();
    }
}
