package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 第一反应是可能需要bit的操作，但是自己不会，所以这个就是盲点，需要补齐。
 * 要解决问题就是从最简单的开始 完全按照题目模拟，O(n)
 * 自己的直觉还有可能会有重复，但是从题目提供的例子，没有发现。
 * 自己的代码改一下，把N设置成大一点的数，去找规律，但是面试的时候肯定是没这个条件
 * 只能assume 或者用别的解法
 * 改进1:用hashmap记录 看是否出现重复的情况 这个时候可以用# of islands 3的套路
 * 数值坐标难以对比，找准坐标系，设立规则，在同一个规则下进行比较
 * 以此作为hashmap的key，第几次循环作为val，但是怎么根据val去找key？这又无解，因为val可以有重复
 * 知识盲点：set到底是怎么存储的？是按照输入的顺序还是？可以找到对应顺序的set吗？
 * @param cells
 * @param N
 * @return
 */
public class PrisonCells {
  public int[] prisonAfterNDays(int[] cells, int N) {
    if (cells == null || cells.length < 8 || N < 1) {
      return new int[0];
    } 
    //int[] oldCells = cells.clone();
    //int[] newCells = new int[8]; 
    //int c = 5 ^ 4;
    int[][] copyCells = new int[2][8];
    copyCells[0] = cells.clone();
    int oldArr = 0,  newArr = 1;
    for (int i = 0; i < N; ++i) {
      // avoid reference problem
      // int[] newCells = new int[8];
      for (int j = 0; j < 8; ++j) {
        if (j == 0 || j == 7) {
          copyCells[newArr][j] = 0;
          continue;
        }
        copyCells[newArr][j] = copyCells[oldArr][j] == copyCells[oldArr][j] ? 1 : 0;
      }
      // Java reference/value passing problem
      // oldCells and newCells both have the same val(reference) of new Cells
      oldArr = newArr;
      newArr = 1 - oldArr;
    }
    return copyCells[oldArr];  
  }

  /**
   * 实验一下用hashmap
   * 错误 进行不下去了 并不是进行不下去
   * 而是还需要重新再计算一遍
   */
  public int[] prisonAfterNDays2(int[] cells, int N) {
    if (cells == null || cells.length < 8 || N < 1) {
      return new int[0];
    }
    Map<String, Integer> cellToDay = new HashMap<>();
    int[][] copyCells = new int[2][8];
    int cnt = 0, oldArr = 0, newArr = 1;
    copyCells[0] = cells.clone();
    String temp;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 8; j++) {
        if (j == 0 || j == 7) {
          copyCells[newArr][j] = 0;
        }
        copyCells[newArr][j] = copyCells[oldArr][j - 1] == copyCells[oldArr][j + 1] ? 1 : 0;
      }
      temp = Arrays.toString(copyCells[newArr]);
      if (cellToDay.containsKey(temp)) {
        break;
      }
      cellToDay.put(temp, i);
      cnt++;
      oldArr = newArr;
      newArr = 1 - oldArr;
    }
    return copyCells[oldArr]; 
  }

  public int[] prisonAfterNDays3(int[] cells, int N) {
    if (cells == null || cells.length < 8 || N < 1) {
      return new int[0];
    }
    Map<Integer, int[]> cellToDay = new HashMap<>();
    int[][] copyCells = new int[2][8];
    int cnt = 0, oldFlag = 0, newFlag = 1;
    copyCells[0] = cells.clone();
    iterate(copyCells, oldFlag, newFlag);
    cellToDay.put(cnt++, copyCells[newFlag]);
    int[] temp = copyCells[newFlag];
    for (int i = 1; i < N; i++) {
      oldFlag = newFlag;
      newFlag = 1 - oldFlag;
      iterate(copyCells, oldFlag, newFlag);
      if (Arrays.equals(copyCells[newFlag], temp)) {
        break;
      }
      cellToDay.put(i, copyCells[newFlag]);
      cnt++;
    }
    return cnt == N ? copyCells[newFlag] : cellToDay.get(N % cnt);
  }

  private void iterate(int[][] nums, int oldFlag, int newFlag) {
    for (int j = 0; j < 8; j++) {
      if (j == 0 || j == 7) {
        nums[newFlag][j] = 0;
      }
      nums[newFlag][j] = nums[oldFlag][j - 1] == nums[oldFlag][j + 1] ? 1 : 0;
    }
  }
}