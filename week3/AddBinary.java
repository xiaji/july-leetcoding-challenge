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
    String res = new String();
    if (a == null || b == null || (a.isEmpty() && b.isEmpty())) {
      return res;
    }
    if (a.length() < b.length()) {
      res = a;
      a = b;
      b = res;
    }
    char[] chsA = a.toCharArray();
    char[] chsB = b.toCharArray();
    int aLength = chsA.length, j = chsB.length - 1, carry = 0;
    //stringbuffer 不支持范型
    StringBuffer sb = new StringBuffer();
    for (int i = aLength - 1; i >= 0; --i) {
      if (chsA[i] == '1') {
        ++carry;
      }
      if (j >= 0 && chsB[j--] == '1') {
        ++carry;
      }

      if (carry % 2 == 1) {
        sb.append('1');
      } else {
        sb.append('0');
      }

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