package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * 分层遍历 BFS 基本操作
 */
public class BinaryTreeZigZag {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int size = 0;
    TreeNode temp = new TreeNode();
    while (!queue.isEmpty()) {
      size = queue.size();
      List<Integer> level = new ArrayList<>();
      while (size-- != 0) {
        temp = queue.poll();
        level.add(temp.val);
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
      res.add(level);
    }
    return res;    
  }
}