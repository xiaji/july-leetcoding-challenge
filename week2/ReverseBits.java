package week2;

/**
 * 按照题目模拟，但是可能会有越界的问题
 * bits manipulate
 */
public class ReverseBits {
  // wrong answer
  public int reverseBitsWrong(int n) {
    long res = 0l;
    int temp;
    while (n != 0) {
      temp = n % 2;
      res = res * 2 + temp;
      n /= 2;
    }
    return (int)res;    
  }
  // another wrong ans
  /**
   * wrong case 11111111111111111111111111111101 
   * Output: 3221225469
   * (10111111111111111111111111111101) 
   * Expected: 3221225471
   * (10111111111111111111111111111111)
   * time limited
   */
  private int reverseBitsWrongLeet(int n) {
    int res = 0, power = 31;
    while (n != 0) {
      res += (n & 1) << power;
      n >>= 1;
      power--;
    }
  }

  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; ++i) {
      // res = res * 2 + temp
      res = (res << 1) | (n & 1);
      // n /= 2
      // n >>= 1
      n = (n >> 1);
    }
    return res;    
  }
}