import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class EvolutionaryAgent extends Agent {
    private double[] xData = {23, 26, 30, 34, 43, 48, 52, 57, 58};
    private double[] yData = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

    protected void setup() {
        addBehaviour(new EvolutionaryBehaviour());
    }

    private class EvolutionaryBehaviour extends OneShotBehaviour {
        private GeneticAlgorithm ga;

        public void action() {
            ga = new GeneticAlgorithm(xData, yData);
            ga.run();
        }

        @Override
        public int onEnd() {
            System.out.println("Comportamiento EvolutionaryBehaviour terminado.");
            return super.onEnd();
        }
    }
}
