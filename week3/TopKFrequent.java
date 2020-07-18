package week3;

import java.util.ArrayList;
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
 */
public class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1) {
      return new int[0];
    }
    // List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> numToFrequent = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    int frq = 0, temp = 0, size = 0;
    for (int num : nums) {
      frq = numToFrequent.getOrDefault(num, 0);
      // numToFrequent.putIfAbsent(num, value);
      temp = numToFrequent.getOrDefault(minHeap.peek(), 0);
      if (frq + 1 > temp && !minHeap.contains(num)) {
        size = minHeap.size();
        minHeap.offer(num);
        if ()
      }
      numToFrequent.put(num, frq + 1);
      
    }    
  }
}