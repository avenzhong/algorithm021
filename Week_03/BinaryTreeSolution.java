import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-15 22:50
 * 翻转二叉树
 */
public class BinaryTreeSolution {

    // 递归
    private void invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
