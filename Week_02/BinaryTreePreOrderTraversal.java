package Week_02;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * 二叉树前序遍历
 * @author: zhongwenjian
 * @create: 2020-12-12 12:12
 */
public class BinaryTreePreOrderTraversal {


    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    // 1. 递归方法
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 2. 迭代
    public List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);

            // 注意：这里right节点要先入栈，而不是left节点
            if (null != root.right) {
                stack.push(root.right);
            }
            if (null != root.left) {
                stack.push(root.left);
            }
        }
        return res;
    }


}
