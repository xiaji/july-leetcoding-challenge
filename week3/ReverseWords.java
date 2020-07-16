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
    //s = reverseString(s.toCharArray(), 0, s.length() - 1);
    int size = s.length(), i = 0, j = 0;
    char[] chs = reverseString(s);
    StringBuffer sb = new StringBuffer();
    while (i < size) {
      if (chs[i] == ' ') {
        i++;
        continue;
      }
      j = i + 1;
      while (j < size) {
        // 死循环
        /*if (chs[j] != ' ') {
          j++;
          continue;
        }*/
        if (chs[j] == ' ') {
          break;
        }
        j++;
      }
      if (sb.length() > 0) {
        sb.append(" ");
      }
      appendString(sb, chs, j - 1, i);
      // 把chs全部转换成string 直接出错
      // sb.append(reverseString(chs, i, j - 1));
      i = j;
    }
    return sb.toString();
  }

  private void appendString(StringBuffer sb, char[] chs, int start, int end) {
    for (int i = start; i >= end; --i) {
      sb.append(chs[i]);
    }
  }

  // mistake: only reverse chs from start to end, and exchange to string
  // what the method does is that change all chs to string
  // it is wrong
  // what we can fix: create a stringbuffer to create a new string
  // but it will cost more space
  // so I create a new method-appendString, stringbuffer is an argument 
  private String reverseString(char[] chs, int start, int end) {
    int left = start, right = end;
    //char[] chs = s.toCharArray();
    char temp = '0';
    while (left < right) {
      temp = chs[right];
      chs[right--] = chs[left];
      chs[left++] = temp;
    }
    return new String(chs);
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