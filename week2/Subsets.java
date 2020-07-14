package week2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  /**
   * DFS经典题目
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    helper(nums, 0, nums.length, new ArrayList<>(), res);
    return res;    
  }

  private void helper(int[] nums, int start, int end, List<Integer> subset, List<List<Integer>> res) {
    // 如果start >= end 放在res.add之前，那就必须是start > end 因为最后一步在end - 1的没有存放进res里
    // start >= end 的成立条件是 res.add放在其之前
    if (start > end) {
      return;
    }
    res.add(new ArrayList<>(subset));
    for (int i = start; i < end; ++i) {
      // 错误点：思路完全是正确的，怎么循环怎么找，search tree的画法
      // 但是传进去的值应该是i，而不是start！！！这样才能跑起来啊，里面的数在改变
      // 而不是错误的一直在几个start之间重复计算
      // subset.add(nums[start]);
      // helper(nums, start + 1, end, subset, res);
      // subset.remove(subset.size() - 1);
      subset.add(nums[i]);
      helper(nums, i + 1, end, subset, res);
      subset.remove(subset.size() - 1);
    }
  }
}