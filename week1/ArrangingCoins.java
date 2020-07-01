package week1;

/**
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */

/**
 * 根据题目的意思，最简单的做法就是从1加到某个临界值，使其大于n，时间复杂度为O(n)  
 * 如果有比O(n)还要低的时间复杂度就是O(logn) 
 * logn的算法：二分法 倍增法 分解因式 最小公约数
 * 这道题目适合二分法，满足OOOOOXXXXX的类型，我们需要找到最后一个 <= n的位置即可
 * 在写代码的时候，有考虑到integer的范围问题，但是觉得前n项和公式里的n被我缩小了范围
 * 但是实际上并不是，因为相乘 k*(k+1)/2 肯定会越界
 * test case: n = 1804289383
 * 修改 sum 函数的返回值类型为long，但是仍然错误
 * 因为传入参数的值类型为int，int * int 仍然会是 int，最后的结果是强制转换为long
 * 但是并不会计算出一个 long，这个错误在二分法的题目出犯过 
 */ 

public class ArrangingCoins {
  public int arrangeCoins(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    
    int start = 1, end = n, mid = 1;
    
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (sum(mid) > n) {
        end = mid;
      } else {
        start = mid;
      }
    }
    
    if (sum(end) <= n) {
      return end;
    }
    
    return start;
  }
  
  private long sum(long k) {
    return k * (k + 1) / 2;
  }
 /** 
  * 没有考虑 int 很大的时候，相乘会越界的问题
  *
  private int sum(int k) {
    return k * (k + 1) / 2;
  }
  */
}