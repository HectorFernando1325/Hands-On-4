public class LinearRegression {
    private double[] xData;
    private double[] yData;
    private double slope;  // B1
    private double intercept;  // B0

    public LinearRegression(double[] xData, double[] yData) {
        this.xData = xData;
        this.yData = yData;
        calculateCoefficients();
    }

    private void calculateCoefficients() {
        int n = xData.length;
        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumX2 = 0.0;

        for (int i = 0; i < n; i++) {
            sumX += xData[i];
            sumY += yData[i];
            sumXY += xData[i] * yData[i];
            sumX2 += xData[i] * xData[i];
        }

        slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        intercept = (sumY - slope * sumX) / n;
    }

    public double predict(double x) {
        return slope * x + intercept;
    }

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }

    @Override
    public String toString() {
        return "y = " + slope + " * x + " + intercept;
    }
}
