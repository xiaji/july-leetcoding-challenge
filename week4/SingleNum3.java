package week4;

import java.util.HashSet;
import java.util.Set;

/**
 * 第一直觉，做过类似的，但是忘记题目编号了。
 * 用set做，碰到一样的直接删除
 * 最后的答案就是了
 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 * toArray()返回 或者是带参数的必须是对象 而不能是int类型
 * toArray()返回的是Object类型
 * 要指定类型要使用toArray(new Integer[0]) 0没有关系 数组会自动allocated
 * 如果知道大小 还是指定size
 */
public class SingleNum3 {
  public int[] singleNumber(int[] nums) {
    if (nums == null || nums.length < 2) {
      return new int[0];
    }
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.add(num)) {
        continue;
      }
      set.remove(num);
    }
    // hashmap的操作
    // for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
    // if (item.getValue() == 1) output[idx++] = item.getKey();
    // new Integer[0] also works
    Integer[] temp = set.toArray(new Integer[2]);
    int[] res = new int[2];
    int idx = 0;
    for (int num : set) {
      res[idx++] = num;
    }
    return res;
  }
}