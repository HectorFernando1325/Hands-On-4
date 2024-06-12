import java.util.Arrays;

public class GeneticAlgorithm {
    private double[] xData;
    private double[] yData;
    private Population population;
    private static final int POPULATION_SIZE = 10;
    private static final double MUTATION_RATE = 0.1;
    private static final int MAX_GENERATIONS = 10;

    public GeneticAlgorithm(double[] xData, double[] yData) {
        this.xData = xData;
        this.yData = yData;
        this.population = new Population(POPULATION_SIZE, xData, yData);
    }

    public void run() {
        Chromosome bestChromosome = null;

        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            population.evaluateFitness();
            bestChromosome = population.selectBestChromosome();
            System.out.println("Generación " + generation + ": Mejor Cromosoma: " + Arrays.toString(bestChromosome.getYData()));
            population.mutatePopulation(MUTATION_RATE);
        }

        LinearRegression lr = new LinearRegression(xData, bestChromosome.getYData());
        System.out.println("Ecuación de Regresión: " + lr);
        System.out.println("B0 (Intercepto): " + lr.getIntercept());
        System.out.println("B1 (Pendiente): " + lr.getSlope());
    }
}
