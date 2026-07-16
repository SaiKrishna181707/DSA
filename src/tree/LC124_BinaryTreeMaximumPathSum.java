public class LC124_BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private static int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Ignore negative contributions
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        // Path passing through current node
        int currentPath = left + right + root.val;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Debug Output
        System.out.println("--------------------------------");
        System.out.println("Current Node      : " + root.val);
        System.out.println("Left Contribution : " + left);
        System.out.println("Right Contribution: " + right);
        System.out.println("Current Path Sum  : " + currentPath);
        System.out.println("Global Max Sum    : " + maxSum);

        int returnValue = root.val + Math.max(left, right);

        System.out.println("Returning         : " + returnValue);

        return returnValue;
    }

    public static void main(String[] args) {

        /*
                    -10
                    /  \
                   9    20
                       /  \
                      15   7

            Expected Answer = 42
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = maxPathSum(root);

        System.out.println();
        System.out.println("================================");
        System.out.println("Maximum Path Sum = " + ans);
    }
}