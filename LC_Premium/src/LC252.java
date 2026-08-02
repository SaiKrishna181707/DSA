/*
 252 : Meeting Rooms

You are given an array of meeting times intervals where intervals[i] = [start i, end i].
A person can attend all meetings if no two meeting intervals overlap. Meetings ending at time t starting at time t do not overlap.
Return true if a person can attend all meetings. Otherwise, return false.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
 */

import java.util.*;
public class LC252 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            matrix[i][0] = input.nextInt();
            matrix[i][1] = input.nextInt();
        }
        System.out.println(meetings(matrix));
        input.close();
    }
    static boolean meetings(int[][] arr) {

        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] < arr[i-1][1]){
                return false;
            }
        }
       return  true;
    }
}
