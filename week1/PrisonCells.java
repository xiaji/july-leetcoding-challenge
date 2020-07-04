package week1;

/**
 * 第一反应是可能需要bit的操作，但是自己不会，所以这个就是盲点，需要补齐。
 * 要解决问题就是从最简单的开始 完全按照题目模拟，O(n)
 * @param cells
 * @param N
 * @return
 */
public class PrisonCells {
  public int[] prisonAfterNDays(int[] cells, int N) {
    if (cells == null || cells.length < 8 || N < 1) {
      return new int[0];
    } 
    int[] oldCells = cells.clone();
    int[] newCells = new int[8]; 
    //int c = 5 ^ 4;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (j == 0 || j == 7) {
          newCells[j] = 0;
          continue;
        }
        newCells[j] = oldCells[j + 1] == oldCells[j - 1] ? 1 : 0;
      }
      oldCells = newCells;
    }
    return oldCells;  
  }
}