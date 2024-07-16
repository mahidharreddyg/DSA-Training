import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class SubtreeCheck {
    // Check if two binary trees are identical
    static boolean areIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.val == root2.val
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    // Check if tree S is a subtree of tree T
    static boolean isSubtree(TreeNode T, TreeNode S) {
        if (S == null) return true; // An empty tree is always a subtree
        if (T == null) return false; // Non-empty tree can't be a subtree of an empty tree

        // If the trees are identical at this node, return true
        if (areIdentical(T, S)) return true;

        // Otherwise, check the subtrees recursively
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example input for Tree T
        TreeNode T = new TreeNode(26);
        T.left = new TreeNode(10);
        T.right = new TreeNode(3);
        T.left.left = new TreeNode(4);
        T.left.right = new TreeNode(6);
        T.left.left.right = new TreeNode(30);
        T.right.right = new TreeNode(3);

        // Example input for Tree S
        TreeNode S = new TreeNode(10);
        S.left = new TreeNode(4);
        S.right = new TreeNode(6);
        S.left.right = new TreeNode(30);

        // Check if S is subtree of T
        if (isSubtree(T, S)) {
            System.out.println("S is subtree of tree T.");
        } else {
            System.out.println("S is NOT a subtree of tree T.");
        }
    }
}
