import java.util.Scanner;
public class MinimumInsertionsToBalanceParentheses {

    public static int minInsertions(String s) {

        int needed = 0;
        int insertions = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // If one ')' is still pending, insert it first
                if (needed % 2 == 1) {
                    insertions++;
                    needed--;
                }

                // Every '(' needs two ')'
                needed += 2;

            } else {

                // Current ')' satisfies one required ')'
                needed--;

                // More ')' than expected
                if (needed < 0) {

                    // Insert one '('
                    insertions++;

                    // Current ')' counts as one ')',
                    // so one more ')' is still needed
                    needed = 1;
                }
            }
        }

        return insertions + needed;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the parentheses string: ");
        String s = sc.nextLine();

        int answer = minInsertions(s);

        System.out.println("Minimum Insertions Required: " + answer);

        sc.close();
    }
}
