package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * 分层遍历 BFS 基本操作
 * 1.只写了基本的 题意没弄懂
 * 2.自己想的zig zag直接是另一个逻辑下的，实际上并不是把把整个层reverse
 *      1     按照我的第二版代码的逻辑 结果会是1,32,564
 *    /   \
 *   2     3
 *  /     / \
 * 4     5   6
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
    boolean flag = false;
    TreeNode temp = new TreeNode();
    while (!queue.isEmpty()) {
      size = queue.size();
      List<Integer> level = new ArrayList<>();
      while (size-- != 0) {
        temp = queue.poll();
        level.add(temp.val);
        /* wrong version
        if (flag) {
          if (temp.right != null) {
            queue.offer(temp.right);
          }
          if (temp.left != null) {
            queue.offer(temp.left);
          }
          continue;
        }*/
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
      if (flag) {
        Collections.reverse(level);
      }
      flag = !flag;
      res.add(level);
    }
    return res;    
  }
}