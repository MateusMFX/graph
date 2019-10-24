package graph.algorithm;

import cern.colt.Arrays;
import graph.Vertex;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class WelshPowell {

    private ListAdjacency list;
    private Color[] colors;

    public WelshPowell(ListAdjacency list) {
        this.list = list;
        this.colors = new Color[]{Color.GREEN, Color.BLUE, Color.RED,
            Color.YELLOW, Color.GRAY, Color.BLACK, Color.WHITE};
    }

    private Vertex getNotPainted(List<Vertex> painted, List<Vertex> listSorted) {
        for (Vertex vertex : listSorted) {
            if (!painted.contains(vertex)) {
                return vertex;
            }
        }
        return null;
    }

    private void paintVertex(Color color, Vertex vertex, List<Vertex> painted) {
        vertex.withColor(color);
        painted.add(vertex);
    }
    
    private boolean isAdjacentSameColor(Color color, Vertex vertex){
        return list.getList().get(vertex).stream()
                .anyMatch(adjacent -> adjacent.getColor() != null 
                        && adjacent.getColor().equals(color));
    }

    public void run() {
        List<Vertex> painted = new LinkedList<>();
        List<Vertex> listSorted = list.sortByDegree();
        int indexColor = 0;

        while (!listSorted.isEmpty() && painted.size() != listSorted.size()) {
            Vertex current = getNotPainted(painted, listSorted);
            paintVertex(colors[indexColor], current, painted);
            for (Vertex vertex : listSorted) {
                if (!painted.contains(vertex)
                        && !list.isAdjacency(current, vertex)
                        && !isAdjacentSameColor(colors[indexColor], vertex)) {
                    paintVertex(colors[indexColor], vertex, painted);
                }
            }
            indexColor++;
        }
    }

}
