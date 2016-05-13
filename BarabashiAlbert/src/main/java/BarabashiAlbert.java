import ru.itis.inform.Graph;
import ru.itis.inform.GraphMatrixImpl;

/**
 * Created by Тимур on 04.05.2016.
 */
public class BarabashiAlbert {
    private Graph graph;
    private int nextVertex = 2;

    public BarabashiAlbert() {
        graph = new GraphMatrixImpl();
        firstInit();
    }

    public BarabashiAlbert(int value) {
        this.graph = new GraphMatrixImpl(value);
        firstInit();
    }

    private void firstInit() {
        graph.addVertex();
        graph.addVertex();
        graph.addEdgeNonDirection(1, 2, 1);
    }

    public void addVertex() {
        graph.addVertex();

        int degree = 0;
        for (int j = 1; j < graph.getVerticeCount(); j++) {
            degree += graph.getDegreeVertex(j);
        }

        for (int i = 1; i < graph.getVerticeCount(); i++) {

            int thisDegreeI = graph.getDegreeVertex(i);
            double chance = (double) thisDegreeI/degree;
            int random = (int)(Math.random()*101);
            chance = (int)(chance*100);
            if (random<=chance) {
                graph.addEdgeNonDirection(graph.getVerticeCount(), i, 1);
            }

        }
    }

    public void showGraph() {
        graph.showGraph();
    }
}
