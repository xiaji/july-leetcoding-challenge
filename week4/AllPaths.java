package week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一反应:DFS
 */
public class AllPaths {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> res = new ArrayList<>();
    if (graph == null || graph.length == 0) {
      return res;
    }
    int n = graph.length;
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, 0, n - 1, path, res);
    return res;    
  }

  private void dfs(int[][] graph, int start, int dest, List<Integer> path, List<List<Integer>> res) {
    if (graph[start] == null || graph[start].length == 0) {
      if (start == dest) {
        res.add(new ArrayList<>(path));
      }
      return;
    }
    for (int node : graph[start]) {
      path.add(node);
      dfs(graph, node, dest, path, res);
      path.remove(path.size() - 1);
    }
  }
}