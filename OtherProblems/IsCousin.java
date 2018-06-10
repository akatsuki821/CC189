package OtherProblems;
/*
Check if two nodes are cousins in a Binary Tree
Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
Two nodes are cousins of each other if they are at same level and have different parents.
 */
// Solution 1: BFS, iterate the tree level by level to check the two nodes are sharing the same parent & on the same level
// Solution 2: DFS, modified LCA

public class IsCousin {
        static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            this.value = value;
        }
    }
    public boolean isCounsin(TreeNode root, TreeNode a, TreeNode b) {
        boolean[] isCousin = new boolean[1];
        LCA(root, a, b, 0, isCousin);
        return isCousin[0];
    }

    private int LCA(TreeNode root, TreeNode a, TreeNode b, int level, boolean[] isCousin) {
        if (root == null) {
            return -1;
        }
        if (root == a || root == b) {
            return level;
        }

        int left = LCA(root.left, a, b, level + 1, isCousin);
        int right = LCA(root.right, a, b, level + 1, isCousin);

        if (left == right && left != -1 && left != level + 1) {
            isCousin[0] = true;
        }
        return left > right ? left : right;
    }
}
