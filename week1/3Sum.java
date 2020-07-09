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
      helper(-nums[i], nums, i + 1, size - 1, res);
    }
    return res;   
  }

  private void helper(int target, int[] nums, int start, int end, List<List<Integer>> res) {
    int left = start, right = end;
    while (left < right) {
      if (nums[left] + nums[right] == target) {
        List<Integer> temp = new ArrayList<>();
        temp.add(-target);
        temp.add(nums[left]);
        temp.add(nums[right]);
        res.add(temp);
        while (left < right && nums[right] == nums[right - 1]) {
          right--;
        }
      }

      if (nums[left] + nums[right] < target) {
        left++;
      }
      
      if (nums[left] + nums[right] > target) {
        right--;
      }
    }
  }
}