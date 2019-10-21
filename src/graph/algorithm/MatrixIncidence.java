package graph.algorithm;

import graph.Directable;
import graph.Link;
import graph.Vertex;
import graph.control.LinkControl;
import graph.control.VertexControl;

/**
 * É uma matriz C de dimensão NxM, onde N é o número de vértices do grafo e M é
 * o número de arestas/arcos É uma matriz numérica Para grafo não dirigido cij =
 * 1 se i for vértice inicial da aresta j cij = 0 caso contrário ou se for laço
 * Para grafo dirigido cij = 1 se i for vértice inicial do arco j cij = -1 se i
 * for vértice final do arco j cij = 0 nos demais casos.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class MatrixIncidence {

    private final Integer[][] matrix;
    private final String[] vertexes, links;
    private final int line, column;

    public MatrixIncidence(ListAdjacency list) {
        this.vertexes = VertexControl.getTags(list.getVertexes());
        this.links = LinkControl.getTags(list.getLinks());
        this.line = vertexes.length;
        this.column = links.length;
        this.matrix = new Integer[line][column];
        fillMatrix(list);
    }

    private void fillMatrix(ListAdjacency list) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = getBeginIncidence(list.getVertexes().get(i),
                        list.getLinks().get(j)) 
                        + getEndIncidence(list.getVertexes().get(i),
                        list.getLinks().get(j), list.getType());
            }
        }
    }

    private int getBeginIncidence(Vertex vertex, Link link) {
        if (vertex.equals(link.getAdjacent())) {
            return 1;
        }
        return 0;
    }

    private int getEndIncidence(Vertex vertex, Link link, Directable direct) {
        if (vertex.equals(link.getVertex())) {
            return direct.getClass() == Directable.Directed.class ? -1 : 1;
        }
        return 0;
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public String[] getVertexes() {
        return vertexes;
    }

    public String[] getLinks() {
        return links;
    }

}
