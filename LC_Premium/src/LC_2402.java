import java.util.*;

public class LC_2402 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = input.nextInt();
            meetings[i][1] = input.nextInt();
        }
        System.out.println(mostBooked(n, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        long[] busyUntil = new long[n];
        int[] meetingsHappened = new int[n];

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            long earlyTime = Long.MAX_VALUE;
            int earlyRoom = 0;
            boolean assigned = false;

            for (int room = 0; room < n; room++) {
                if (busyUntil[room] <= meeting[0]) {
                    busyUntil[room] = meeting[1];
                    meetingsHappened[room]++;
                    assigned = true;
                    break;
                } else if (busyUntil[room] < earlyTime) {
                    earlyTime = busyUntil[room];
                    earlyRoom = room;
                }
            }
            if (!assigned) {
                busyUntil[earlyRoom] += meeting[1] - meeting[0];
                meetingsHappened[earlyRoom]++;
            }
        }
        int ans = 0;
        for (int room = 1; room < n; room++) {
            if (meetingsHappened[room] > meetingsHappened[ans]) {
                ans = room;
            }
        }
        return ans;
    }
}
