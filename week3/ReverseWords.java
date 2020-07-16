package week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 这个题目做过，但是没有review，第一个方法里有个知识点，就是空格split的结果是空串
 */
public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    // 进化的split("\\s + ") 但是仍然是留下开头全是空的情况;
    String[] ss = s.split(" ");
    int index = ss.length - 1;
    //StringBuilder 线程不安全
    StringBuffer sb = new StringBuffer();
    // mistake 1: index-- 
    while (index >= 0) {
      if (ss[index].isEmpty()) {
        index--;
        continue;
      }
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(ss[index--]);
    }
    return sb.toString();
  }
  // leetcode split version ans
  public String reverseWordsLeetCode(String s) {
    // remove leading spaces
    s = s.trim();
    // split by multiple spaces
    List<String> wordList = Arrays.asList(s.split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }

  // 如果不让用split函数 或者说trim函数，trim:remove leading space
  // 相向双指针
  public String reverseWords2(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    char[] chs = reverseString(s);
    int left = 0, right = chs.length - 1;
    while (left < right) {
      
    }
  }

  private char[] reverseString(String s) {
    int left = 0, right = s.length() - 1;
    char[] chs = s.toCharArray();
    char temp = '0';
    while (left < right) {
      temp = chs[right];
      chs[right--] = chs[left];
      chs[left++] = temp;
    }
    return chs;
  }
}