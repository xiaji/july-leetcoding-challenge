package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * topo排序
 * 问题在1.隐式图的处理 用什么样的数据结构来存储 里面有技巧 自己有总结过 不复习就忘了
 * 2.topo排序用BFS还是DFS
 */
public class CourseSchedule {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses < 1 || prerequisites == null || prerequisites.length == 0 
    || prerequisites[0] == null || prerequisites[0].length != 2) {
      return new int[0];
    }

    // missing one condition, no need for numCourses > 1 && no pre condition
    int[] res = new int[numCourses];
    //这样会出现错误 没有范型数组
    //List<Integer>[] graph = new ArrayList<>[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    // 因为直接是index->course->indegree
    // Map<Integer, Integer> courseToDegree = new HashMap<>();
    int[] indegrees = new int[numCourses];
    int i = 0, cnt = 0;
    for (i = 0; i < numCourses; ++i) {
      graph.add(new ArrayList<Integer>());
      indegrees[i] = 0;
    }
    for (int[] course : prerequisites) {
      graph.get(course[1]).add(course[0]);
      indegrees[course[0]]++;
      // courseToDegree.put(course[0], courseToDegree.getOrDefault(course[0], 0) + 1);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }
    int course = 0;
    while (!queue.isEmpty()) {
      course = queue.poll();
      res[cnt++] = course;
      for (int next : graph.get(course)) {
        indegrees[next]--;
        if (indegrees[next] != 0) {
          continue;
        }
        queue.offer(next);
      } 
    }
    return cnt == numCourses ? res : new int[0];
  }
}