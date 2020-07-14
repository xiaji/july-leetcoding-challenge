package week1;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0) {
      return new int[0];
    }
    int size = digits.length;
    int flag = 1, temp = 0;
    int[] res = digits.clone();
    for (int i = size - 1; i >= 0; --i) {
      temp = digits[i] + flag;
      res[i] = temp > 9 ? 0 : temp;
      flag = temp > 9 ? 1 : 0;
    }
    
    if (flag == 1) {
      res = new int[size + 1];
      res[0] = flag;
      for (int i = 1; i <= size; ++i) {
        res[i] = 0;
      }
    }
    
    return res;
  }
}