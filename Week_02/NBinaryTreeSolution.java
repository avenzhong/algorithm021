package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-13 11:01
 */
public class NBinaryTreeSolution {

    // 迭代
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            // 从最后面开始放进栈中，出栈时就是从左到右了
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }

    List<Integer> list = new ArrayList<>();
    // 递归
    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder1(node);
        }
        return list;
    }


}
