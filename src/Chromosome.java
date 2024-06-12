public class Chromosome {
    private double[] yData;
    private double fitness;

    public Chromosome(double[] yData) {
        this.yData = yData;
        this.fitness = Double.MAX_VALUE;
    }

    public double[] getYData() {
        return yData;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
