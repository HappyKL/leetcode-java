package com.ict.kang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-03 15:15
 * @description :
 * @modified :
 */
public class ValidateBinarySearchTree98 {

    /**
     * @Date 2019-09-03 15:44 
     * @Description 通过中序遍历，然后比较序列
     * @param root
     * @Return boolean
     **/
    public boolean isValidBST1(TreeNode root) {

        List<Integer> array = new ArrayList<>();
        inorder(array, root);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Date 2019-09-03 15:44 
     * @Description 中序遍历
     * @param array
     * @param root
     * @Return void
     **/
    private void inorder(List<Integer> array, TreeNode root) {

        if (root == null) {
            return;
        }
        inorder(array, root.left);
        array.add(root.val);
        inorder(array, root.right);
    }

    /**
     * @Date 2019-09-03 15:46 
     * @Description 使用上下界
     * @param root
     * @Return boolean
     **/
    public boolean isValidBST2(TreeNode root) {

        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode root,Integer low ,Integer high) {
        if(root==null) return true;
        if(low!=null && root.val <= low) return false;
        if(high!=null && root.val >= high) return false;
        return isValid(root.left,low,root.val) && isValid(root.right,root.val,high);
    }


}
