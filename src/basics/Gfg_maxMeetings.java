package basics;

/*
Given two arrays s[] and f[], where s[i] and f[i] denote the start time and finish time of the ith
meeting, respectively. There is only one meeting room. A meeting can be scheduled only if its start
time is strictly greater than the finish time of the previously selected meeting.

Find the maximum number of meetings that can be scheduled in the room such that no two selected
meetings overlap. Return the indices (1-based) of the selected meetings in sorted (increasing) order.

Note: If multiple schedules are possible, prefer meetings with earlier finish times. If two meetings
have the same finish time, prefer the meeting with the smaller index.
Examples:

Input: s[] = [1, 3, 0, 5, 8, 5], f[] = [2, 4, 6, 7, 9, 9]
Output: [1, 2, 4, 5]

Explanation: We can attend the 1st meeting from (1 to 2), then the 2nd meeting from (3 to 4), then
the 4th meeting from (5 to 7), and the last meeting we can attend is the 5th from (8 to 9). It can be
shown that this is the maximum number of meetings we can attend.
*/

import java.util.*;

public class Gfg_maxMeetings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] meetings = new int[n][3];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = input.nextInt(); // start
            meetings[i][1] = input.nextInt(); // finish
            meetings[i][2] = i + 1; // original index
        }
        System.out.println(maxMeetings(meetings));
        input.close();
    }
    public static ArrayList<Integer> maxMeetings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) ->
        {if (a[1] != b[1]) {return a[1] - b[1];}
            return a[2] - b[2];
        });
        ArrayList<Integer> list = new ArrayList<>();
        int lastFinish = -1;
        for (int i = 0; i < meetings.length; i++) {

            if (meetings[i][0] > lastFinish) {
                list.add(meetings[i][2]);
                lastFinish = meetings[i][1];
            }
        }
        Collections.sort(list);
        return list;
    }
}
