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
 * Algoritimo de busca em largura do grafo, consiste em marcar uma vértice
 * inicial, que será acrescentado a uma fila de exploração, então inicio um laço
 * de exploração, que consiste em localizar todos os laços adjacentes e acrestar
 * em uma fila de exploração, caso seja encontrado alguma vértice na qual já foi
 * explorado, é ignorado e passado para o próximo da lista, a condição de para é
 * a fila de exploração estiver totalmente vazia.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class BreadthFirstSearch {

    private Vertex start;
    private List<Vertex> visited;
    private Stack<Vertex> toVisit;
    private List<Link> links;
    private Directable type;
    private Vertex visit;

    public BreadthFirstSearch(ListAdjacency list) {
        this.links = list.getLinks().stream().collect(Collectors.toList());
        this.visited = new ArrayList<>();
        this.toVisit = new Stack<>();
        this.type = list.getType();
        this.start = null;
    }

    public Vertex getStart() {
        return start;
    }

    public BreadthFirstSearch withStart(Vertex start) {
        this.start = start;
        return this;
    }

    public boolean isVisited(Vertex vertex) {
        return visited.contains(vertex);
    }

    public ListAdjacency runBFS() throws NoSuchElementException {
        ListAdjacency list = new ListAdjacency(type).addVertex(start);
        toVisit.push(start);
        loopBFS(list);
        return list;
    }

    private List<Link> getAllLinks(Vertex vertex) {
        return links.stream()
                .filter(link -> (vertex.equals(link.getVertex())
                || (type.getClass() == Directable.Directed.class
                ? false : vertex.equals(link.getAdjacent())))
                && (!visited.contains(link.getAdjacent())
                || (type.getClass() == Directable.Directed.class
                ? false : !visited.contains(link.getVertex()))))
                .collect(Collectors.toList());
    }

    private void loopBFS(ListAdjacency list) throws NoSuchElementException {
        while (!toVisit.isEmpty()) {
            Vertex mark = toVisit.pop();
            List<Link> adjacents = getAllLinks(mark);
            visited.add(mark);
            adjacents.forEach(link -> {
                Vertex aux;
                if (type.getClass() == Directable.Directed.class) {
                    aux = link.getAdjacent();
                } else {
                    aux = link.getVertex().equals(mark) ? link.getAdjacent() : link.getVertex();
                }
                visited.add(aux);
                toVisit.add(aux);
            });
            adjacents.forEach(link -> list.addLink(link));
        }
    }

}
