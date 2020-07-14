package week1;

/**
 * 刚开始想到了根据最后一位来判断，如果不是9，就直接最后一位加1，返回值
 * 在编码过程中，发现直接和for循环放在一起即可，这样在最后判断carry是否为1
 * 有考虑过换成integer，在加1，但是否定的理由是先for循环构造数字，再加1，再分开，两次for循环
 * 但是真正的理由应该是integer类型的stackoverflow，甚至long也可以，题目并没有明说数组的大小范围
 * 如果n可以很大，换成integer或者long都是不可取的，这样类似的问题，第一个排除的就应该是此方法。
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0) {
      return new int[0];
    }
    int size = digits.length;
    int carry = 1, temp = 0;
    int[] res = digits.clone();
    for (int i = size - 1; i >= 0; --i) {
      temp = digits[i] + carry;
      res[i] = temp > 9 ? 0 : temp;
      carry = temp > 9 ? 1 : 0;
    }
    
    if (carry == 1) {
      res = new int[size + 1];
      res[0] = carry;
      for (int i = 1; i <= size; ++i) {
        res[i] = 0;
      }
    }
    
    return res;
  }
}