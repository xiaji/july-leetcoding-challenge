package week2;

/**
 * 单纯模拟题目：时针所对应的是0.2h/unit
 * 分针所对应的是1min/unit
 * 度数是6angle/unit
 * 需要注意的是要用double做类型
 */
public class AngleHands {
  public double angleClock(int hour, int minutes) {
    if (hour <= 0 || hour > 12 || minutes < 0 || minutes >= 60) {
      return 0.0;
    }
    double hourUnit = 0.2, minUnit = 1.0, degree = 6.0;
    // mistake 1: hour / hourunit
    // double hourTotal = (hour + minutes / 60.0) * hourUnit;
    double hourTotal = (hour + minutes / 60.0) / hourUnit;
    // mistake 2: min / minunit
    // double minTotal = minUnit * minutes;
    double minTotal = minutes / minUnit;
    double res = Math.abs(hourTotal - minTotal) * degree;
    return Math.min(res, 360.0 - res);
  }
}