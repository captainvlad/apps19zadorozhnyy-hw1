import java.lang.Math;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public double[] temp;
    int current_size;
    public boolean empty = false;

    public TemperatureSeriesAnalysis() {
        empty = true;
    }

    public void check_smallest(double[] arg){
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < -273)
                throw new InputMismatchException("You can't put less than -273 in array!");
        }
    }

    public void check_smallest_added(double... arg){
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < -273)
                throw new InputMismatchException("You can't put less than -273 in array!");
        }
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        check_smallest(temperatureSeries);
        this.temp = temperatureSeries;
        this.current_size = temperatureSeries.length;
    }

    public void check(){
        if (empty == true){
            throw new IllegalArgumentException("Array is empty!");
        }
    }

    public double average() {
        check();
        float sum = 0f;
        for (int i = 0; i < this.temp.length ; i++) {
            sum += this.temp[i];
        }
        return sum / this.temp.length;
    }

    public double deviation() {
        check();
        double averag = this.average();
        double sum = 0;
        for (int i = 0; i < temp.length ; i++) {
            sum += Math.pow((temp[i] - averag), 2);
        }
        return Math.sqrt(sum / temp.length);
    }

    public double min() {
        check();
        double current_min = temp[0];
        for (int i = 1; i < temp.length; i++) {
            current_min = temp[i] < current_min ? temp[i]: current_min;
        }
        return current_min;
    }

    public double max() {
        check();
        double current_max = temp[0];
        for (int i = 1; i < temp.length; i++) {
            current_max = temp[i] > current_max ? temp[i]: current_max;
        }
        return current_max;
    }

    public double findTempClosestToValue(double tempValue) {
        check();
        double current_difference = Math.abs(tempValue - Math.abs(temp[0]));
        double current_element = temp[0];
        for (int i = 0; i < temp.length; i++) {
            if(Math.abs(tempValue - Math.abs(temp[i])) < current_difference){
                current_difference = Math.abs(tempValue - Math.abs(temp[i]));
                current_element = temp[i];
            }
            else if(Math.abs(tempValue - Math.abs(temp[i])) == current_difference){
                current_element = current_element < temp[i] ? temp[i] : current_element;
            }
        }
        return current_element;
    }

    public double findTempClosestToZero() {
        if (empty == true) {
            throw new IllegalArgumentException("Array is empty");
        }
        return this.findTempClosestToValue(0);
    }

    public double[] findTempsLessThen(double tempValue) {
        check();
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue)
                k ++;
        }
        double[] result = new double[k];
        int f = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue){
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
            if (temp[i] >= tempValue)
                k ++;
        }
        double[] result = new double[k];
        int f = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= tempValue){
                result[f] = temp[i];
                f++;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        check();
        final TempSummaryStatistics result = new TempSummaryStatistics();
        result.setAvgTemp(average());
        result.setDevTemp(deviation());
        result.setMaxTemp(max());
        result.setMinTemp(min());
        return result;
    }

    public int addTemps(double... temps) {
        this.temp = this.temp.length == 0? new double[1]: this.temp;
        check_smallest_added(temps);
        double[] result = (temp.length < current_size + temps.length) ? new double[2 * temp.length]: temp;
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i];
        }
        for (int i = 0; i < temps.length; i++) {
            result[i + current_size] = temps[i];
            current_size ++;
        }
        this.temp = result;
        return current_size;
    }
}
