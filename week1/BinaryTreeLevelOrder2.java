package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 * int val; 
 * TreeNode left; 
 * TreeNode right; 
 * TreeNode() {} 
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { 
 * this.val = val; 
 * this.left = left; this.right = right; } }
 */
// BFS 
public class BinaryTreeLevelOrder2 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int size = 0;
    //List<Integer> temp = new ArrayList<>();
    TreeNode node = new TreeNode();
    while (!queue.isEmpty()) {
      size = queue.size();
      temp.clear();
      for (int i = 0; i < size; ++i) {
        node = queue.poll();
        List<Integer> temp = new ArrayList<>();
        // temp.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      // this is a mistake, reference problem
      // the final res is the same 
      res.add(temp);
    }
    return Collections.reverse(res);
  }

  //DFS
  public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
  }
}