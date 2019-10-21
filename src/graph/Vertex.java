package graph;

import graph.viewer.VertexViewer;
import java.util.Objects;

/**
 * Vértice são os pontos (elementos) de um grafo, possui um rótulo para
 * descrição
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class Vertex implements Comparable<Vertex> {

    private final Object element;

    public Vertex(Object element) {
        this.element = element;
    }

    public Vertex(Vertex copy) {
        this.element = copy.element;
    }

    public String getTag() {
        return element.toString();
    }

    @Override
    public String toString() {
        return VertexViewer.status(this);
    }

    @Override
    public int compareTo(Vertex o) {
        return element.toString().compareTo(o.element.toString());
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == Vertex.class
                && element.equals(((Vertex) o).element);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.element);
        return hash;
    }

}
