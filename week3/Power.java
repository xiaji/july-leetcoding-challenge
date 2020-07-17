package week3;

/**
 * 快速幂问题 logN做法
 * 这次是double类型
 * 需要注意的点是 1.n为负数 尤其是2的31次方 如果直接对n取相反数直接就越界了 2.循环和递归做法
 */

public class Power {
  public double myPow(double x, int n) {
    int newN = 0;
    if (n < 0) {
      x = 1.0 / x;
      if (n == Integer.MIN_VALUE) {
        newN = Integer.MAX_VALUE;
      } else {
        newN = -n;
      }
    }
    return n == Integer.MIN_VALUE ? helper(x, newN) * x : helper(x, newN);    
  }

  private double helper(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    double temp = helper(x, n / 2);
    temp *= temp;
    if (n % 2 == 0) {
      return temp;
    }
    return temp * x;
  }
}