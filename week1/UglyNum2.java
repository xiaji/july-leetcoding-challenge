package week1;

import java.util.PriorityQueue;

/**
 * 出错的两个点 1.重复性的问题 2.数值范围的问题 test case：1407 所以必须是要练习的
 */
public class UglyNum2 {
  public int nthUglyNumber(int n) {
    if (n < 1) {
      return 0;
    }
    
    PriorityQueue<Long> pq = new PriorityQueue<>();
    int[] a = {2, 3, 5};
    pq.offer(1L);
    long res = 0L;
    for (int i = 0; i < n; ++i) {
      res = pq.poll();
      for (int j = 0; j < 3; ++j) {
        if (pq.contains(res * a[j])) {
          continue;
        }
        pq.offer(res * a[j]);
      }
    }
    return (int)res;
  }
}