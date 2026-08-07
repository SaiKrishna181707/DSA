package greedy;

/*
Given two arrays, val[] and wt[], representing the values and weights of item respectively, and an
integer capacity representing the maximum weight a knapsack can hold, we have to determine the
maximum total value that can be achieved by putting the items in the knapsack without exceeding its
capacity.
Items can also be taken in fractional parts if required.

Examples:
Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240

Explanation: We will take the items of weight 10kg and 20kg and 2/3 fraction of 30kg.
Hence total value will be 60 + 100 + (2/3) * 120 = 240.

Input: val[] = [500], wt[] = [30], capacity = 10
Output: 166.667
*/


import java.util.*;
class Item{
    int val;
    int weight;
    Item(int val, int weight){
        this.val = val;
        this.weight = weight;
    }
}
public class fractionalKnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] values = new int[n];
        for(int i = 0; i <n; i++){
            values[i] = sc.nextInt();
        }
        int[] weights = new int[n];
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();

        Item[] items = new Item[n];
        for(int i = 0; i < n; i++){
            items[i] = new Item(values[i],weights[i]);
        }
        Arrays.sort(items,(a,b) -> Double.compare((double) b.val/ b.weight,
                (double) a.val/a.weight));

        double ans = 0;

        for(Item item : items){

            if(capacity >= item.weight){
                ans += item.val;
                capacity -= item.weight;
            }else{
                ans += ((double)item.val * capacity) / item.weight;
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
