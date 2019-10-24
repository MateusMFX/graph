package graph;

import graph.viewer.LinkViewer;
import java.util.LinkedList;
import java.util.List;

/**
 * Ligação entre duas vértices na qual possui um custo de fluxo, podendo possuir
 * uma ligação de fluxo duplo (aresta), ou com um fluxo único (arco).
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class Link implements Comparable<Link> {

    private Vertex vertex, adjacent;
    private String tag;
    private int cost;

    public Link(String tag) {
        this.vertex = null;
        this.adjacent = null;
        this.tag = tag;
        this.cost = -1;
    }

    public Link(Link copy) {
        this.vertex = new Vertex(copy.vertex);
        this.adjacent = new Vertex(copy.adjacent);
        this.tag = copy.tag;
        this.cost = copy.cost;
    }

    public String getTag() {
        return tag;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public Vertex getAdjacent() {
        return adjacent;
    }

    public int getCost() {
        return cost;
    }

    public Link withVertex(Vertex vertex) {
        this.vertex = vertex;
        return this;
    }

    public Link withAdjacent(Vertex adjacent) {
        this.adjacent = adjacent;
        return this;
    }

    public Link withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Link withCost(int cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public String toString() {
        return LinkViewer.status(this);
    }

    @Override
    public boolean equals(Object o) {
        return compareTo((Link) o) == 0;
    }

    @Override
    public int compareTo(Link link) {
        return tag.compareTo(link.tag);
    }

    public static List<Link> clone(List<Link> copy) {
        List<Link> list = new LinkedList<>();
        copy.forEach(link -> {
            list.add(new Link(link));
        });
        return list;
    }
}
