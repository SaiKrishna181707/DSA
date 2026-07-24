package arrays;

public class LC76 {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }
        int formed = 0;
        int required = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int start = 0;
        int[] need = new int[128];
        int[] window = new int[128];
        for (char ch : t.toCharArray()) {
            if (need[ch] == 0) {
                required++;
            }
            need[ch]++;
        }
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;

            if (need[s.charAt(right)] > 0 && window[s.charAt(right)] == need[s.charAt(right)]) {
                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                window[s.charAt(left)]--;

                if (need[s.charAt(left)] > 0 && window[s.charAt(left)] < need[s.charAt(left)]) {
                    formed--;
                }
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLength);
    }
}
