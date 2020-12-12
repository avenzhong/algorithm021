package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-12 16:14
 */
public class BinaryTreeInOrderTraversal {

    // 递归方法 根-->左-->右
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (res == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    // 迭代方法
    // 1. 先把左子树的所有子节点循环遍历放入栈中
    // 2. 然后对栈判空循环遍历
    // 3. 在每次循环过程中出栈一个node，并把node的val放入链表中
    // 4. 再传入当前node的right节点调用putAllLeft方法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        putAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            putAllLeft(cur.right, stack);
        }
        return res;
    }

    public void putAllLeft(TreeNode node, Stack stack) {
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 2;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 6;
        left.right = right;
        TreeNode left1 = new TreeNode();
        left1.val = 3;
        left.left = left1;
        TreeNode left2 = new TreeNode();
        left2.val = 4;
        left1.left = left2;
        TreeNode right1 = new TreeNode();
        right1.val = 5;
        left1.right = right1;
        TreeNode left3 = new TreeNode();
        left3.val = 7;
        right1.left = left3;
        TreeNode right2 = new TreeNode();
        right2.val = 8;
        right1.right = right2;
        TreeNode left4 = new TreeNode();
        left4.val = 9;
        right2.left = left4;

        BinaryTreeInOrderTraversal inOrderTraversal = new BinaryTreeInOrderTraversal();
        List<Integer> list = inOrderTraversal.inorderTraversal(root);

        // 中序遍历输出4、3、7、5、9、8、2、6、1
        System.out.println(list);
    }
}
