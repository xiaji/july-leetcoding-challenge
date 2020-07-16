package week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
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
      while (j < size && chs[j] != ' ') {
        j++;
      }
     /*while (j < size) {
        // 死循环
        /if (chs[j] != ' ') {
          j++;
          continue;
        }/
        if (chs[j] == ' ') {
          break;
        }
        j++;
      }*/
      if (sb.length() > 0) {
        sb.append(" ");
      }
      appendString(sb, chs, j - 1, i);
      // 把chs全部转换成string 直接出错
      // sb.append(reverseString(chs, i, j - 1));
      // i = j + 1, chs[j] = ' '
      i = j + 1;
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

  /**
   * 第三个方法用Deque做，直接把word插在最前面
   * 为什么不用linkedlist或者arraylist 原因就是时间复杂度 
   * ArrayList.add(int index, E e) O(n)
   * LinkedList.add(int index, E e) mid O(n) tail/head o(1)
   */
  public String reverseWords3(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    int left = 0, right = s.length() - 1;
    char[] chs = s.toCharArray();
    while (left <= right && chs[left] == ' ') {
      left++;
    }
    
    while (left <= right && chs[right] == ' ') {
      right--;
    }

    StringBuffer word = new StringBuffer();
    Deque<String> dequeq = new LinkedList<>();
    char temp = ' ';
    // 不管上面的left <= right是否有等号，这里这个条件是必须要有的
    // 很可能这里left == right，如果没有=，最后的结果可能是什么都没有
    // 或者少最后一个字母，因为right是可以取的，且非空。
    while (left <= right) {
      temp = chs[left];
      // 这个循环把word长度为0，且temp为空的情况下就什么都不做，left++即可
      if (word.length() != 0 && temp == ' ') {
        dequeq.addFirst(word.toString());
        word.setLength(0);
      } else if (temp != ' ') {
        word.append(temp);
      }
      left++;
    }

    dequeq.addFirst(word.toString());
    return String.join(" ", dequeq);
  }

  private StringBuffer trimSpace(String s) {
    int left = 0, right = s.length() - 1;
    char[] chs = s.toCharArray();
    while (left <= right && chs[left] == ' ') {
      left++;
    }
    while (left <= right && chs[right] == ' ') {
      right--;
    }
    StringBuffer sb = new StringBuffer();
    while (left <= right) {
      if (chs[left] != ' ') {
        sb.append(chs[left]);
      } else if (chs[left] == ' ' && chs[left - 1] != ' ') {
        sb.append(' ');
      }
      left++;
    }
    return sb;
  }
 }