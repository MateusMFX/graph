package graph.algorithm;

import graph.Vertex;
import graph.viewer.FloydWarshallViewer;

public class FloydWarshall {

    private ListAdjacency list;
    private int size;
    private Integer[][] cost;
    private Vertex[][] predecessors;
    private String log;

    public FloydWarshall(ListAdjacency list) {
        this.list = list;
        this.size = list.getVertexes().size();
        this.log = "";
        createMatrixes();
    }

    private void createMatrixes() {
        cost = new Integer[size][size];
        predecessors = new Vertex[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cost[i][j] = list.getCostBetweenVertex(list.getVertexes().get(i),
                        list.getVertexes().get(j));
                predecessors[i][j] = list.getVertexes().get(i);
            }
        }
    }

    public ListAdjacency getList() {
        return list;
    }

    public Integer[][] getCost() {
        return cost;
    }

    public Vertex[][] getPredecessors() {
        return predecessors;
    }

    public String getLog() {
        return log;
    }

    private void iteratorFloyd(int k) {
        for (int i = 0; i < size; i++) {
            if (cost[i][k] != -1) {
                for (int j = 0; j < size; j++) {
                    if (cost[k][j] != -1 && 
                            (cost[i][j] > cost[i][k] + cost[k][j] || cost[i][j] == -1)) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }
    }

    public FloydWarshall run() {
        log += "k = 0\n\n";
        log += "Custo\n" + FloydWarshallViewer.statusCost(this) + '\n';
        log += "\nPredecessores:\n" + FloydWarshallViewer.statusPredecessors(this) + '\n';

        for (int k = 0; k < size; k++) {
            log += "k = " + (k + 1) + "\n\n";
            iteratorFloyd(k);
            log += "Custo\n" + FloydWarshallViewer.statusCost(this) + '\n';
            log += "\nPredecessores:\n" + FloydWarshallViewer.statusPredecessors(this) + '\n';
        }
        return this;
    }
}
