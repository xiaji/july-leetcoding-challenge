package week2;

public class SameTree {
  /**
   * 二叉树的问题 左右子树 分治法
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    
    if (p == null || q == null) {
      return false;
    }

    boolean isLeftSameTree = isSameTree(p.left, q.left);
    boolean isRightSameTree = isSameTree(p.right, q.right);
    return isLeftSameTree & isRightSameTree & p.val == q.val;
  }
}