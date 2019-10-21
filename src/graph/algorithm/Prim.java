package graph.algorithm;

import graph.Directable;
import graph.Link;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Algoritmo de Prim consiste em encontrar uma árvore geradora mínima, ou seja,
 * ligações com menor custo com todas as vértices do grafo, consiste de um ponto
 * de saída, verifica todos as ligações e escolhe a ligação com menor custo,
 * acrescenta a outra vértice a lista de vértice já visitada, e repete-se a
 * sequência de verificação de todas as ligações de todas as vértices visitadas,
 * seguindo esse algoritmo até visitar todas as vértices do grafo.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class Prim {

    private Vertex start;
    private List<Vertex> vertexes, visited;
    private List<Link> links;
    private Directable type;

    public Prim(ListAdjacency list) {
        this.vertexes = list.getVertexes().stream().collect(Collectors.toList());
        this.links = list.getLinks().stream().collect(Collectors.toList());
        this.visited = new ArrayList<>();
        this.type = list.getType();
        this.start = null;
    }

    public Vertex getStart() {
        return start;
    }

    public Prim withStart(Vertex start) {
        this.start = start;
        return this;
    }

    public boolean isVisited(Vertex vertex) {
        return visited.contains(vertex);
    }

    public Link getCheapLink() throws NoSuchElementException {
        return links.stream()
                .filter(link -> !visited.contains(link.getVertex())
                || (type.getClass() == Directable.Directed.class 
                        ? false : !visited.contains(link.getAdjacent())))
                .min(Comparator.comparing(Link::getCost))
                .get();
    }

    public ListAdjacency runPrim() throws NoSuchElementException {
        ListAdjacency list = new ListAdjacency(type).addVertex(start);
        vertexes.remove(start);
        visited.add(start);
        loopPrim(list);
        return list;
    }

    private void loopPrim(ListAdjacency list) throws NoSuchElementException {
        while (!vertexes.isEmpty()) {
            Link cheap = getCheapLink();
            visited.add(cheap.getAdjacent());
            visited.add(cheap.getVertex());
            list.addLink(cheap);
            links.remove(cheap);
            vertexes.remove(cheap.getAdjacent());
            vertexes.remove(cheap.getVertex());
        }
    }

}
