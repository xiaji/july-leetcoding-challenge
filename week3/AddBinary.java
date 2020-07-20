package week3;

/**
 * 用解决 plus one 的做法 当时的leetcode题解没看 也没总结
 * 1.错误的方法：用的与或计算位上的值 出现 0 ^ 0 = 1
 * wrong case：
 * Input: "1010" "1011"
 * Output: "11111"
 * Expected: "10101"
 */

public class AddBinary {
  public String addBinary(String a, String b) {
    // String res = new String();
    if (a == null || b == null || (a.isEmpty() && b.isEmpty())) {
      return res;
    }
    if (a.length() < b.length()) {
      //res = a;
      //a = b;
      //b = res;
      return addBinary(b, a);
    }
    char[] chsA = a.toCharArray();
    char[] chsB = b.toCharArray();
    int aLength = chsA.length, j = chsB.length - 1, carry = 0;
    //stringbuffer 不支持范型
    StringBuffer sb = new StringBuffer();
    for (int i = aLength - 1; i >= 0; --i) {
      // 目标就是carry既可以作为append的char，又可以保存进位的值
      if (chsA[i] == '1') {
        ++carry;
      }
      // b一直都是最短的 既然没有对应的位数了 那就可以不加不管
      if (j >= 0 && chsB[j--] == '1') {
        ++carry;
      }
      //二进制基本操作
      if (carry % 2 == 1) {
        sb.append('1');
      } else {
        sb.append('0');
      }
      // 这步很重要 carry有可能最多是3 那进位的话 我们仍然需要进位1
      // 为2也需要进位1 为1的时候不用管 
      // 模拟二进制的加法 跟十进制一样
      carry /= 2;
      /*if (j < 0) {
        j = 0;
        chsB[j] = '0';
      }
      sb.append((chsA[i] ^ chsB[j]) ^ carry);
      carry = chsA[i] + chsB[j] + carry > 1 ? 1 : 0;
      j--;*/
    }
    if (carry > 0) {
      sb.append(carry);
    }  
    sb.reverse();
    return sb.toString();
  }
}