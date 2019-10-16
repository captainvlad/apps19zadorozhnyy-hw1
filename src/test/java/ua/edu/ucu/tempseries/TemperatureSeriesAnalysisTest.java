import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {
    double[] array = {1,2,3,4};

    double[] arr = {1,2,3,4};
    double[] arr_2 = {};

    TemperatureSeriesAnalysis ars = new TemperatureSeriesAnalysis(array);
    TemperatureSeriesAnalysis ars_1 = new TemperatureSeriesAnalysis();

    @Test(expected = InputMismatchException.class)
    public void check_smallest() {
        double[] wrong_array = {-274, 5};
        ars.check_smallest(wrong_array);
    }

    @Test(expected = InputMismatchException.class)
    public void check_smallest_added() {
        ars.addTemps(-275);
        ars.addTemps(25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void check() {
        ars.check();
        ars_1.check();
    }

    @Test(expected = IllegalArgumentException.class)
    public void average() {
        ars.average();
        ars_1.average();
        assertEquals(ars.average(), 2.5, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deviation() {
        assertEquals(ars.deviation(), 1.1, 0.1);
        ars_1.deviation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void min() {
        assertEquals(ars.min(), 1, 0);
        ars_1.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void max() {
        assertEquals(ars.max(), 4, 0);
        ars_1.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTempClosestToValue() {
        assertEquals(ars.findTempClosestToValue(2), 2, 0);
        ars_1.findTempClosestToValue(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTempClosestToZero() {
        assertEquals(ars.findTempClosestToZero(), 1, 0);
        ars_1.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTempsLessThen() {
        assertArrayEquals(ars.findTempsLessThen(10), arr, 0);
        assertArrayEquals(ars.findTempsLessThen(0), arr_2, 0);
       ars_1.findTempsLessThen(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTempsGreaterThen() {
        assertArrayEquals(ars.findTempsGreaterThen(10), arr_2, 0);
        assertArrayEquals(ars.findTempsGreaterThen(0), arr, 0);
        ars_1.findTempsGreaterThen(0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void summaryStatistics() {
        TempSummaryStatistics a = ars.summaryStatistics();
        assertEquals(a.getAvgTemp(), 2.5, 0);
        assertEquals(a.getDevTemp(), 1.1, 0.1);
        assertEquals(a.getMaxTemp(), 4, 0);
        assertEquals(a.getMinTemp(), 1, 0);
        TempSummaryStatistics b = ars_1.summaryStatistics();
    }

    @Test
    public void addTemps() {
        assertEquals(ars.addTemps(2), 5, 0);
        assertEquals(ars.temp.length, 8, 0);
        assertEquals(ars.addTemps(2), 6, 0);
        assertEquals(ars.temp.length, 8, 0);

    }
}