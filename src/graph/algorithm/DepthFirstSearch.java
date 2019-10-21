package graph.algorithm;

import graph.Directable;
import graph.Link;
import graph.Vertex;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Algoritmo de Busca em profundidade de grafo
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class DepthFirstSearch {

    private Vertex start;
    private List<Vertex> visited;
    private Stack<Vertex> toVisit;
    private List<Link> links;
    private Directable type;
    private Vertex visit;

    public DepthFirstSearch(ListAdjacency list) {
        this.links = list.getLinks().stream().collect(Collectors.toList());
        this.visited = new ArrayList<>();
        this.toVisit = new Stack<>();
        this.type = list.getType();
        this.start = null;
    }

    public Vertex getStart() {
        return start;
    }

    public DepthFirstSearch withStart(Vertex start) {
        this.start = start;
        return this;
    }

    public boolean isVisited(Vertex vertex) {
        return visited.contains(vertex);
    }

    public ListAdjacency runDFS() throws NoSuchElementException {
        ListAdjacency list = new ListAdjacency(type).addVertex(start);
        toVisit.push(start);
        loopDFS(list);
        return list;
    }

    private Link getFirstLink(Vertex vertex) {
        return links.stream()
                .filter(link -> (vertex.equals(link.getVertex())
                || (type.getClass() == Directable.Directed.class
                ? false : vertex.equals(link.getAdjacent())))
                && (!visited.contains(link.getAdjacent())
                || (type.getClass() == Directable.Directed.class
                ? false : !visited.contains(link.getVertex()))))
                .findFirst().orElse(null);

    }

    private void loopDFS(ListAdjacency list) throws NoSuchElementException {
        while (!toVisit.isEmpty()) {
            Vertex mark = toVisit.peek();
            Link link = getFirstLink(mark);
            visited.add(mark);
            if (link != null) {
                Vertex aux;
                if (type.getClass() == Directable.Directed.class) {
                    aux = link.getAdjacent();
                } else {
                    aux = link.getVertex().equals(mark) ? link.getAdjacent() : link.getVertex();
                }
                visited.add(aux);
                toVisit.add(aux);
                list.addLink(link);
            }else{
                toVisit.pop();
            }
        }
    }
}
