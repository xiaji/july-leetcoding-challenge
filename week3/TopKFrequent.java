package week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 用hashmap记录
 * 1.使用put方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null；
 * 如果已经存在对应的值，则会覆盖旧值，value为新的值。
 * 2.使用putIfAbsent方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null；
 * 如果已经存在对应的值，则依旧为原来的值。
 * 错误1:想直接用Map作为Heap的比较单位，写不出来，为什么？其实可以Integer对比，其实自己也是这么想的
 * 但是比较的时候，借用map，比较其对应的val的值，这样就可以了，要重新写comparator。
 * heap的那节忘记了，不扎实，要重新看视频。
 */
public class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1) {
      return new int[0];
    }
    // List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> numToFrequent = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
      @Override
      public int compare(Integer a, Integer b) {
        if (numToFrequent.get(a) == numToFrequent.get(b)) {
          return 0;
        }
        return numToFrequent.get(a) < numToFrequent.get(b) ? -1 : 1;
      }
    });
    int frq = 0;
    for (int num : nums) {
      frq = numToFrequent.getOrDefault(num, 0);
      // numToFrequent.putIfAbsent(num, value);
      numToFrequent.put(num, frq + 1);
    }
    
    for (int key : numToFrequent.keySet()) {
      minHeap.offer(key);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] results = new int[k];
    while (!minHeap.isEmpty()) {
      results[--k] = minHeap.poll();
    }
    return results;
  }
}