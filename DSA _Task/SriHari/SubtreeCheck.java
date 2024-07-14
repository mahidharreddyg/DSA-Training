import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class SubtreeCheck {

    // Function to check if two trees are identical
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.val == root2.val) &&
               isIdentical(root1.left, root2.left) &&
               isIdentical(root1.right, root2.right);
    }

    // Function to check if S is a subtree of T
    public boolean isSubtree(TreeNode T, TreeNode S) {
        if (S == null) return true;
        if (T == null) return false;

        if (isIdentical(T, S)) return true;

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    // Function to build a tree from input
    public TreeNode buildTree(Scanner scanner) {
        System.out.println("Enter node value (-1 for null): ");
        int val = scanner.nextInt();
        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        root.left = buildTree(scanner);
        System.out.println("Enter right child of " + val);
        root.right = buildTree(scanner);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubtreeCheck check = new SubtreeCheck();

        System.out.println("Build tree T:");
        TreeNode T = check.buildTree(scanner);

        System.out.println("Build tree S:");
        TreeNode S = check.buildTree(scanner);

        if (check.isSubtree(T, S)) {
            System.out.println("S is a subtree of T.");
        } else {
            System.out.println("S is not a subtree of T.");
        }
    }
}
