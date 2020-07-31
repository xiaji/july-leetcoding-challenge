package week5;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
      return res;
    }
    // StringBuffer sb = new StringBuffer();
    char[] chs = s.toCharArray();
    dfs(chs, new ArrayList<>(), 0, wordDict, res);
    return res;
  }

  private void dfs(char[] chs, List<String> subList, int start, List<String> dict, List<String> res) {
    if (start == chs.length) {
      res.add(String.join(" ", new ArrayList<>(subList)));
      return;
    }
    StringBuffer temp = new StringBuffer();
    for (int i = start; i < chs.length; ++i) {
      temp.append(chs[i]);
      if (!dict.contains(temp.toString())) {
        continue;
      }
      subList.add(temp.toString());
      dfs(chs, subList, i + 1, dict, res);
      subList.remove(subList.size() - 1);
    }
  }
}