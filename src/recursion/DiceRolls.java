import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceRolls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the target:");
        int n = in.nextInt();
        List<String> result = combinations("",n);
        System.out.println(result);
        }
        static List<String> combinations(String p, int target){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=target && i <= 6;i++){
            list.addAll(combinations(p+i,target-i));
        }
        return list;
    }
}
