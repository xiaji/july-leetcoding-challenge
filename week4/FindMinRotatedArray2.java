package week4;

/**
 * 有重复元素存在就直接搜
 * 为什么？
 */
public class FindMinRotatedArray2 {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }    
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num < min) {
        min = num;
      }  
    }
    return min;
  }
}