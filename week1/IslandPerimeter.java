package week1;

/**
 * 想到了铺地毯 P3397 前缀和和差分 https://oi-wiki.org/basic/prefix-sum/
 * 这道题目也可以这么来，算差分，现在的和前一个的差，循环四个方向，把边计算出来
 * 最后的和即为答案
 */
public class IslandPerimeter {
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    int n = grid.length, m = grid[0].length;
    int i = 0, j = 0, sum = 0;
    // from left to right    
    for (j = 0 ; j < m; ++j) {
      for (i = 0; i < n; ++i) {
        if (j == 0 && grid[i][j] == 1) {
          sum += 1;
        }
        if (j > 0 && grid[i][j] - grid[i][j - 1] == 1) {
          sum += 1;
        }
      }
    }

    // from right to left
    for (j = m - 1 ; j >= 0; --j) {
      for (i = 0; i < n; ++i) {
        if (j == m - 1 && grid[i][j] == 1) {
          sum += 1;
        }
        if (j < m - 1 && grid[i][j] - grid[i][j + 1] == 1) {
          sum += 1;
        }
      }
    }

    // from top to down
    for (i = 0 ; i < n; ++i) {
      for (j = 0; j < m; ++j) {
        if (i == 0 && grid[i][j] == 1) {
          sum += 1;
        }
        if (i > 0 && grid[i][j] - grid[i - 1][j] == 1) {
          sum += 1;
        }
      }
    }

    for (i = n - 1 ; i >= 0; --i) {
      for (j = 0; j < m; ++j) {
        if (i == n - 1 && grid[i][j] == 1) {
          sum += 1;
        }
        if (i < n - 1 && grid[i][j] - grid[i + 1][j] == 1) {
          sum += 1;
        }
      }
    }

    return sum;
  }
}