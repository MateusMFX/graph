package graph;

import graph.viewer.VertexViewer;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import util.Reflection;

/**
 * Vértice são os pontos (elementos) de um grafo, possui um rótulo para
 * descrição
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class Vertex implements Comparable<Vertex> {

    private final Object element;
    private Color color;

    public Vertex(Object element) {
        this.element = element;
        this.color = null;
    }

    public Vertex(Vertex copy) {
        this.element = Reflection.clone(copy.element);
        this.color = copy.color;
    }

    public String getTag() {
        return element.toString();
    }

    public Color getColor() {
        return color;
    }
    
    public Vertex withColor(Color color) {
        this.color = color;
        return this;
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
                && element.toString().equals(((Vertex) o).element.toString());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.element.toString());
        return hash;
    }

    public static List<Vertex> clone(List<Vertex> copy) {
        List<Vertex> list = new LinkedList<>();
        copy.forEach(vertex -> {
            list.add(new Vertex(vertex));
        });
        return list;
    }

}
