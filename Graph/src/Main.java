/**
 * Created by Тимур on 09.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        graph g = new graphImpl();

        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();

        g.addEdge(1,3,5);

        g.showGraph();
    }
}
