package com.ict.kang.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-05 23:22
 * @description :
 * @modified :
 */
public class BinaryTreeLevelOrderTraversal102 {

    class QueueNode {

        TreeNode treeNode;
        int level;

        QueueNode(TreeNode treeNode, int level) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }
    /**
     * @Date 2019-09-05 23:55
     * @Description
     * @param root
     * @Return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<QueueNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(new QueueNode(root, 1));

        List<QueueNode> treeNodeList = new ArrayList<>();
        List<Integer> valList = new ArrayList<>();
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            if (!treeNodeList.isEmpty() && queueNode.level != treeNodeList.get(0).level) {
                result.add(new ArrayList<>(valList));
                treeNodeList.clear();
                valList.clear();
            }
            treeNodeList.add(queueNode);
            valList.add(queueNode.treeNode.val);

            TreeNode treeNode = queueNode.treeNode;
            if (treeNode.left != null) {
                queue.add(new QueueNode(treeNode.left, queueNode.level + 1));
            }
            if (treeNode.right != null) {
                queue.add(new QueueNode(treeNode.right, queueNode.level + 1));
            }
        }
        if(!valList.isEmpty()){
            result.add(valList);
        }
        return result;
    }

}
