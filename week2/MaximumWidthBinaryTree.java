package week1;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.internal.jshell.tool.resources.l10n;

/**
 * 1.Queue是否可以放null？
 * 2.因为是按照层，所以第一反应是BFS 也就是树的遍历问题
 * 第一份逻辑不对 队列里加入null去判断 很麻烦
 * 加一个变量 或者状态 从数组的角度去看 或者说借鉴heapify的构成方法 其实就是最简单的index的差值 
 */
public class MaximumWidthBinaryTree {
  public int widthOfBinaryTreeWrong(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    int size = 0, cnt = 0, start = 0, end = 0, res = Integer.MIN_VALUE;
    TreeNode temp = null;
    queue.offer(root);
    while (!queue.isEmpty()) {
      size = queue.size();
      cnt = 0;
      while (cnt != size) {
        while (queue.peek() == null) {
          queue.poll();
          cnt++;
          queue.offer(null);
          queue.offer(null);
        }
        start = cnt;
        //写不下去了 逻辑错误
      }
    }    
  }

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    // 既然想到了每层的start end 为何不给他直接按照编号来 不是每层的编号 而是父亲的编号来
    // 使用sift up 和 sift down的方法来 binary lifting 这个应该是常规技巧 必要熟悉
    // 尽量避免新建一个对象 这样算起来很耗时和空间 借鉴BFS的题目踩过的坑 两个queue一一对应
    Queue<Integer> index = new LinkedList<>();
    queue.offer(root);
    index.offer(0);
    int res = Integer.MIN_VALUE, size = 0;
    int tail = 0, head = 0;
    TreeNode temp = null;
    while (!queue.isEmpty()) {
      size = queue.size();
      head = index.peek();
      for (int i = 0; i < size; ++i) {
        temp = queue.poll();
        tail = index.poll();
        if (temp.left != null) {
          queue.offer(temp.left);
          index.offer(tail * 2 + 1);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
          index.offer(tail * 2 + 2);
        }
      }
      res = Math.max(res, tail - head + 1);
    }
    return res;
  }
}