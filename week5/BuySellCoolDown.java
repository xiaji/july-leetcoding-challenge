package week5;

/**
 * 无限次的买卖，但是在卖之后必须休息一天
 */
public class BuySellCoolDown {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }    
    int res = 0, i = 1;
    while (i != prices.length) {
      while (prices[i] - prices[i - 1] > 0) {
        res += prices[i] - prices[i - 1];
        i++;
      }
      i++;
    }
    return res;
  }
}