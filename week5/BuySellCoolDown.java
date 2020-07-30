package week5;

/**
 * 无限次的买卖，但是在卖之后必须休息一天
 * while循环尤其是跟数组index相关时 一定要把边界大小放在最前面
 */
public class BuySellCoolDown {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }    
    int res = 0, i = 1, sz = prices.length;
    while (i < sz) {
      while (i < sz && prices[i] - prices[i - 1] > 0) {
        res += prices[i] - prices[i - 1];
        i++;
      }
      i++;
    }
    return res;
  }
}