import java.util.Random;

public class Population {
    private Chromosome[] chromosomes;
    private double[] xData;
    private double[] yData;
    private Random random;

    public Population(int populationSize, double[] xData, double[] yData) {
        this.chromosomes = new Chromosome[populationSize];
        this.xData = xData;
        this.yData = yData;
        this.random = new Random();
        generateInitialPopulation();
    }

    private void generateInitialPopulation() {
        for (int i = 0; i < chromosomes.length; i++) {
            double[] yDataRandom = new double[yData.length];
            for (int j = 0; j < yData.length; j++) {
                yDataRandom[j] = random.nextDouble() * 2000; // Rango aleatorio basado en los datos de yData
            }
            chromosomes[i] = new Chromosome(yDataRandom);
        }
    }

    public void evaluateFitness() {
        for (Chromosome chromosome : chromosomes) {
            LinearRegression lr = new LinearRegression(xData, chromosome.getYData());
            double mse = 0.0;
            for (int i = 0; i < yData.length; i++) {
                double prediction = lr.predict(xData[i]);
                mse += Math.pow(prediction - yData[i], 2);
            }
            mse /= yData.length;
            chromosome.setFitness(mse);
        }
    }

    public Chromosome selectBestChromosome() {
        Chromosome bestChromosome = chromosomes[0];
        for (Chromosome chromosome : chromosomes) {
            if (chromosome.getFitness() < bestChromosome.getFitness()) {
                bestChromosome = chromosome;
            }
        }
        return bestChromosome;
    }

    public void mutatePopulation(double mutationRate) {
        for (Chromosome chromosome : chromosomes) {
            double[] yData = chromosome.getYData();
            for (int i = 0; i < yData.length; i++) {
                if (random.nextDouble() < mutationRate) {
                    yData[i] = random.nextDouble() * 2000; // Rango aleatorio basado en los datos de yData
                }
            }
        }
    }

    public Chromosome[] getChromosomes() {
        return chromosomes;
    }
}
