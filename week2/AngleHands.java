package week2;

/**
 * 单纯模拟题目：时针所对应的是0.2h/unit
 * 分针所对应的是1min/unit
 * 度数是6angle/unit
 * 需要注意的是要用double做类型
 * 单位都是xx/格 所以要用格来比的话 就得用除法 算出对应的格数
 * 之后再于每格所对应的度数相乘
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
  // leetcode 详解
  // 1. 从我的思路来看 要经过一次换算 那就直接把angle和hour，min对应起来
  // 360/60 = 6 angle/min 360/12 = 30 angle/h
  // 2. 在第一次错误的计算下，思考过如果hour == 12，int hour = hour == 12 ? 0 : hour
  // 这个就等价于对hour进行取模操作 hour % 12
  public double angleClock2(int hour, int minutes) {
    int oneMinAngle = 6;
    int oneHourAngle = 30;

    double minutesAngle = oneMinAngle * minutes;
    double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

    double diff = Math.abs(hourAngle - minutesAngle);
    return Math.min(diff, 360.0 - diff);
  }
}