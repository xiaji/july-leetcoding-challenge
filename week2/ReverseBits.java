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