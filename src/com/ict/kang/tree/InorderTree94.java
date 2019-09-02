package com.ict.kang.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-02 15:05
 * @description : leetcode 94 - 树的中序遍历
 * @modified :
 */
public class InorderTree94 {

    /**
     * @Date 2019-09-02 15:28
     * @Description 用递归实现中序遍历
     * @Return java.util.List<java.lang.Integer>
     **/
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    /**
     * @Date 2019-09-02 15:42
     * @Description 递归函数
     * @Return void
     **/
    private void inorder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(result, root.left);
        result.add(root.val);
        inorder(result, root.right);
    }


    /**
     * @Date 2019-09-02 15:28
     * @Description 用栈实现中序遍历
     * @Return java.util.List<java.lang.Integer>
     **/
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.empty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            TreeNode tempNode = s.pop();
            result.add(tempNode.val);
            node = tempNode.right;
        }
        return result;
    }
}
