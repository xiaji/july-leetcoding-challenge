package week3;

/**
 * 快速幂问题 logN做法
 * 这次是double类型
 * 需要注意的点是 1.n为负数 尤其是2的31次方 如果直接对n取相反数直接就越界了 2.循环和递归做法
 * 应该记住的技巧，为了避免1的取相反数越界情况，把所有的负数的相反数都 + 1，最后再乘起来
 */

public class Power {
  public double myPow(double x, int n) {
    int newN = n;
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

  // update above method
  public double myPow1(double x, int n) {
    boolean isNegative = false;
    if (n < 0) {
      isNegative = true;
      x = 1.0 / x;
      // avoid over boundary
      n = - (n + 1);
    }
    return isNegative ? helper(x, n) * x : helper(x, n);
  }

  private double helper(double x, int n) {
    // mistake: one condition n == 1
    // or result would be 1.0 always
    if (n == 1) {
      return x;
    }
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

  // recursion: better way
  public double myPow2(double x, int n) {
    if (n == 1) {
      return x;
    }
    if (n == 0) {
      return 1.0;
    }
    double temp = myPow(x, n / 2);
    if (n % 2 == 0) {
      return temp * temp;
    } else if (n % 2 == 1) {
      return temp * temp * x;
    }
    return temp * temp / x;
  }

  // for loop method
  public double myPow3(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    boolean isNegative = false;
    if (n < 0) {
      x = 1 / x;
      n = - (n + 1);
      isNegative = true;
    }

    double ans = 1.0, base = x;
    while (n != 0) {
      if (n % 2 == 1) {
        ans *= base;
      }
      base *= base;
      n /= 2;
    }

    return isNegative ? ans * x : ans;
  }
}