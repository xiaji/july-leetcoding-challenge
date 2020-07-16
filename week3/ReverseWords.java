package week3;

/**
 * 这个题目做过，但是没有review，第一个方法里有个知识点，就是空格split的结果是空串
 */
public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    String[] ss = s.split(" ");
    int index = ss.length - 1;
    //StringBuilder 线程不安全
    StringBuffer sb = new StringBuffer();
    while (index >= 0) {
      if (ss[index].isEmpty()) {
        continue;
      }
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(ss[index]);
    }
    return sb.toString();
  }
}