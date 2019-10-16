import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    double[] temp;
    int currentSize;
    boolean empty;
    int critical;

    public TemperatureSeriesAnalysis() {
        empty = true;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        critical = -273;
        empty = false;
        checkSmallest(temperatureSeries);
        this.temp = temperatureSeries;
        this.currentSize = temperatureSeries.length;
    }

    public void checkSmallest(double[] arg) {
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < critical) {
                throw new InputMismatchException("You "
                        + "can't put less than -273 in array!");
            }
        }
    }

    public void checkSmallestAdded(double... arg) {
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < critical) {
                throw new InputMismatchException("You"
                        + " can't put less than -273 in array!");
            }
        }
    }

    public void check() {
        if (empty) {
            throw new IllegalArgumentException("Array is empty!");
        }
    }

    public double average() {
        check();
        float sum = 0f;
        for (int i = 0; i < this.temp.length; i++) {
            sum += this.temp[i];
        }
        return sum / this.temp.length;
    }

    public double deviation() {
        check();
        double averag = this.average();
        double sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += ((temp[i] - averag) * (temp[i] - averag));
        }
        return Math.sqrt(sum / temp.length);
    }

    public double min() {
        check();
        double currentMin = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] < currentMin) {
                currentMin = temp[i];
            }
        }
        return currentMin;
    }

    public double max() {
        check();
        double currentMax = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > currentMax) {
                currentMax = temp[i];
            }
        }
        return currentMax;
    }

    public double findTempClosestToValue(double tempValue) {
        check();
        double currentDifference = Math.abs(tempValue - Math.abs(temp[0]));
        double currentElement = temp[0];
        for (int i = 0; i < temp.length; i++) {
            if (Math.abs(tempValue - Math.abs(temp[i])) < currentDifference) {
                currentDifference = Math.abs(tempValue - Math.abs(temp[i]));
                currentElement = temp[i];
            }
            else if (Math.abs(tempValue - Math.abs(temp[i]))
                    == currentDifference) {
                if (currentElement < temp[i]) {
                    currentElement = temp[i];
                }
            }
        }
        return currentElement;
    }

    public double findTempClosestToZero() {
        if (empty) {
            throw new IllegalArgumentException("Array is empty");
        }
        return this.findTempClosestToValue(0);
    }

    public double[] findTempsLessThen(double tempValue) {
        check();
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue) {
                k++;
            }
        }
        double[] result = new double[k];
        int f = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue) {
                result[f] = temp[i];
                f++;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        check();
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= tempValue) {
                k++;
            }
        }
        double[] result = new double[k];
        int f = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= tempValue) {
                result[f] = temp[i];
                f++;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        check();
        final TempSummaryStatistics Result = new TempSummaryStatistics();
        Result.setAvgTemp(average());
        Result.setDevTemp(deviation());
        Result.setMaxTemp(max());
        Result.setMinTemp(min());
        return Result;
    }

    public int addTemps(double... temps) {
        double[] result;
        if (temp.length == 0) {
            temp = new double[1];
        }
        checkSmallestAdded(temps);
        if (temp.length < currentSize + temps.length) {
            result = new double[2 * temp.length];
        }
        else {
            result = temp;
        }
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i];
        }
        for (int i = 0; i < temps.length; i++) {
            result[i + currentSize] = temps[i];
            currentSize++;
        }
        this.temp = result;
        return currentSize;
    }
}
