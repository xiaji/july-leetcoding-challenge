package week4;

/**
 * binray tree traversal 基础题目
 * 用inorder来构建 postorder最后一个就是根
 * mistake：不要去找两边各自的分界点，找长度，这样只需要扫描数组一遍
 */
public class ConstructBinaryTreeInAndPostOrder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // miss one condition
    if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0
      || inorder.length != postorder.length) {
      return new TreeNode();
    }
    return helper(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);    
  }

  private TreeNode helper(int inStartIdx, int inEndIdx, int[] inorder, int postStartIdx, 
    int postEndIdx, int[] postorder) {
      // miss one condition
      if (inStartIdx > inEndIdx || postStartIdx > postEndIdx) {
        return null;
      }
      TreeNode root = new TreeNode(postorder[postEndIdx]);
      int idx = inStartIdx;
      while (idx <= inEndIdx && inorder[idx] != postorder[postEndIdx]) {
        idx++;
      }
      int leftLength = idx - inStartIdx;
      root.left = helper(inStartIdx, idx - 1, inorder, postStartIdx, postStartIdx + leftLength - 1, postorder);
      root.right = helper(idx + 1, inEndIdx, inorder, postStartIdx + leftLength, postEndIdx - 1, postorder);
      return root;
  }

  // useless method
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