package graph.viewer;

import graph.algorithm.FloydWarshall;
import graph.control.VertexControl;
import util.control.StringControl;

public abstract class FloydWarshallViewer {

    public static String statusCost(FloydWarshall floyd) {
        String[] vertexex = VertexControl.getTags(floyd.getList().getVertexes());
        return "\n" + StringControl.matrixViewer(floyd.getCost(), vertexex,
                vertexex, maxLength(vertexex));
    }

    public static String statusPredecessors(FloydWarshall floyd) {
        String[] vertexex = VertexControl.getTags(floyd.getList().getVertexes());
        return "\n" + StringControl.matrixViewer(floyd.getPredecessors(), vertexex,
                vertexex, maxLength(vertexex));
    }

    private static int maxLength(String[] vertexes) {
        int max = 0;
        for (String tag : vertexes) {
            max = tag.length() > max ? tag.length() : max;
        }
        return max;
    }
}
