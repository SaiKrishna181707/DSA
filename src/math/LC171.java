package math;

import java.util.HashMap;

class Solution {
    public int LC171(String input) {
        String custom = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i< custom.length() ; i++){
            map.put(custom.charAt(i), i+1);
        }
        int sum = 0;
        int place_value = 1;

        for(int i = input.length() - 1; i >= 0; i--){
            sum += map.get(input.charAt(i)) * place_value;
            place_value *= 26;
        }
        return sum;
    }
}