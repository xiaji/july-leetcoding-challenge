package week1;

/**
 * 双指针的基础题目 稍微的变形 就是题目 
 * 这时候就是对求解目标进行编程 使其变成已知题目
 */
public class 3Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return res;
    }
    int size = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < size - 2; ++i) {
      //duplicates
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      helper(-nums[i], nums, i + 1, size - 1, res);
    }
    return res;   
  }

  private void helper(int target, int[] nums, int start, int end, List<List<Integer>> res) {
    int left = start, right = end;
    while (left < right) {
      // 不能放在最后，再right--，逻辑上不对，先做这个，再判断其他情况
      // mistake1: left < right!!! indexofbound
      while (left && right && nums[left] + nums[right] < target) {
        left++;
      }
      // mistake1: left < right case:[-1, 0, 1, 2, -1, -4]
      // without left < right, wrong res:[-4,2,2] left == right
      if (left < right && nums[left] + nums[right] == target) {
        List<Integer> temp = new ArrayList<>();
        temp.add(-target);
        temp.add(nums[left]);
        temp.add(nums[right]);
        res.add(temp);
        while (left < right && nums[right] == nums[right - 1]) {
          right--;
        }
      }
      right--;
      /* 可以更简单点
      if (nums[left] + nums[right] < target) {
        left++;
      }
      
      if (nums[left] + nums[right] > target) {
        right--;
      }*/
    }
  }
}