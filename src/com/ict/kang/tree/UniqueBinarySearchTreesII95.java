package com.ict.kang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-03 12:45
 * @description :
 * @modified :
 */
public class UniqueBinarySearchTreesII95 {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int z = 0; z < rightTrees.size(); z++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTrees.get(j);
                    node.right = rightTrees.get(z);
                    res.add(node);
                }
            }
        }

        return res;

    }

}
