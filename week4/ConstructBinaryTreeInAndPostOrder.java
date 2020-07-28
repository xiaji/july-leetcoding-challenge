package week4;

/**
 * binray tree traversal 基础题目
 * 用inorder来构建 postorder最后一个就是根
 */
public class ConstructBinaryTreeInAndPostOrder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
      return new TreeNode();
    }
    return helper(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);    
  }

  private TreeNode helper(int inStartIdx, int inEndIdx, int[] inorder, int postStartIdx, 
    int postEndIdx, int[] postorder) {
      if (inStartIdx > inEndIdx) {
        return null;
      }
      TreeNode root = new TreeNode(postorder[postEndIdx]);
      int rootIdx = findIndex(postorder[postEndIdx], inorder);
      root.left = helper(inStartIdx, rootIdx - 1, inorder, postStartIdx, postEndIdx, postorder)
  }

  private int findIndex(int val, int[] nums) {
    int idx = 0;
    for (int num : nums) {
      if (num != val) {
        idx++;
      }
      return idx;
    }
    return -1;
  }
}