package statsarene;

public class StatsArene {
  public static Integer[] scores = { 42, 87, 15, 99, 63, 87, 5, 71, 99, 34, 50, 28 };

  public static Integer moyenne() {
    Integer sum = 0;
    for (Integer i = 0; i < scores.length; i++) {
      sum += scores[i];
    }

    return sum / scores.length;
  }

  public static Integer max() {
    Integer max;
    Integer currentMax = 0;
    for (Integer i = 0; i < scores.length; i++) {
      if (currentMax < scores[i]) {
        currentMax = scores[i];
      }
    }

    max = currentMax;
    return max;
  }

  public static Integer min() {
    Integer min;
    Integer currentMin = 0;
    for (Integer i = 0; i < scores.length; i++) {
      if (currentMin > scores[i]) {
        currentMin = scores[i];
      }
    }

    min = currentMin;
    return min;
  }

  public static Integer[] descendingOrder(Integer[] t) {
    Integer[] copyArr = t.clone();
    for (int i = 0; i < copyArr.length - 1; i++) {
      for (int j = 0; j < copyArr.length - 1 - i; j++) {

        if (copyArr[j] < copyArr[j + 1]) {
          Integer temp = copyArr[j];
          copyArr[j] = copyArr[j + 1];
          copyArr[j + 1] = temp;
        }
      }
    }

    return copyArr;
  }
}