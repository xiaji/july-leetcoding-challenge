package week3;

/**
 * 用解决 plus one 的做法 当时的leetcode题解没看 也没总结
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
  }
}