public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public void setAvgTemp(double avTemp) {
        this.avgTemp = avTemp;
    }

    public void setMaxTemp(double maTemp) {
        this.maxTemp = maTemp;
    }

    public void setDevTemp(double deTemp) {
        this.devTemp = deTemp;
    }

    public void setMinTemp(double miTemp) {
        this.minTemp = miTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }
}
