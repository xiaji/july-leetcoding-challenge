package week4;

public class AddDigits {
  public int addDigits(int num) {
    if (num <= 9) {
      return num;
    }
    int carry = 0;
    while (num != 0) {
      carry += num % 10;
      if (carry > 9) {
        carry = carry % 10 + carry / 10;
      }
      num /= 10;
    }
    return carry;   
  }
}