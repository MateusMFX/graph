package graph.algorithm;

import graph.Directable;
import graph.Directable.Directed;
import graph.Directable.UnDirected;
import graph.Link;
import graph.Vertex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lista de Adjacência é composta por um vetor V de dimensão N, Cada elemento de
 * V contém 2 campos: a identificação do vértice e um ponteiro para uma lista
 * encadeada contendo os vizinhos deste vértice Implementação pode ser via Vetor
 * de listas Lista de listas
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class ListAdjacency {

    private Map<Vertex, List<Vertex>> list;
    private List<Link> links;
    private Directable type;

    public ListAdjacency(Directable type) {
        this.type = type;
        this.list = new HashMap<>();
        this.links = new ArrayList<>();
    }

    public ListAdjacency(ListAdjacency copy) {
        this.type = Directable.copy(type);
        this.list = ListAdjacency.clone(list);
        this.links = Link.clone(links);

    }

    public ListAdjacency addVertex(Vertex vertex) {
        if (!getVertexes().contains(vertex)) {
            list.put(vertex, new ArrayList<>());
        }
        return this;
    }

    public ListAdjacency removeVertex(Vertex vertex) {
        removeFromAllAdjacents(vertex);
        list.remove(vertex);
        return this;
    }

    public void removeFromAllAdjacents(Vertex adjacent) {
        list.forEach((key, value)
                -> value.removeIf(vertex
                        -> vertex.getTag().equals(adjacent.getTag())));
        links.removeIf(link -> link.getAdjacent().equals(adjacent)
                || link.getVertex().equals(adjacent));
    }

    public boolean isAdjacency(Vertex vertex, Vertex adjacent) {
        if (!vertex.getTag().isEmpty() || !adjacent.getTag().isEmpty()
                || !list.isEmpty()) {
            return list.get(vertex).stream()
                    .anyMatch(ajcts -> ajcts.equals(adjacent));
        }
        return false;
    }

    public ListAdjacency addLink(Link link) {
        if (!links.contains(link)) {
            links.add(link);
            addVertex(link.getVertex());
            addVertex(link.getAdjacent());
            type.addLink(this, link);
        }
        return this;
    }

    public ListAdjacency removeLink(Link link) {
        Link aux = links.stream().filter(l -> l.equals(link)).findAny().orElse(null);
        if (aux != null) {
            type.removeLink(this, aux);
            links.remove(aux);
        }
        return this;
    }

    public List<Vertex> getVertexes() {
        return new ArrayList<>(list.keySet()).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void rebuildList(Directable direction) {
        this.type = direction;
        this.list = new HashMap<>();
        List<Link> copy = links.stream().collect(Collectors.toList());
        this.links = new ArrayList<>();
        copy.forEach(link -> addLink(link));
    }

    public Map<Vertex, List<Vertex>> getList() {
        return list;
    }

    public Directable getType() {
        return type;
    }

    public List<Link> getLinks() {
        return links;
    }

    public int getTotalCost() {
        return links.stream()
                .collect(Collectors.summingInt(Link::getCost));
    }

    public boolean isThereCicleComprimentThree() {
        for (Vertex vertex : getVertexes()) {
            for (Vertex adjacent : list.get(vertex)) {
                for (Vertex nextAdjacent : list.get(adjacent)) {
                    if (list.get(nextAdjacent).contains(vertex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPlanarity() {
        int qtdVertex = list.size();
        int qtdLink = links.size();
        if (!isThereCicleComprimentThree()) {
            return qtdLink <= qtdVertex * 2 - 4;
        }
        return qtdLink <= qtdVertex * 3 - 6;
    }

    public int getCostBetweenVertex(Vertex v1, Vertex v2) {
        if(v1.equals(v2)){
            return 0;
        }
        
        int cost = getCostByType(v1, v2);
        if (cost == -1 && type instanceof UnDirected) {
            cost = getCostByType(v2, v1);
        }
        return cost;
    }

    private int getCostByType(Vertex v1, Vertex v2) {
        return links.stream()
                .filter(link -> link.getVertex().equals(v1)
                && link.getAdjacent().equals(v2))
                .map(link -> link.getCost())
                .findFirst().orElse(-1);
    }

    public List<Vertex> sortByDegree() {
        return list.entrySet().stream()
                .sorted((v1, v2) -> Integer.compare(v2.getValue().size(), v1.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<Vertex, List<Vertex>> clone(Map<Vertex, List<Vertex>> copy) {
        Map<Vertex, List<Vertex>> newList = new HashMap<>();
        copy.forEach((key, value) -> {
            newList.put(new Vertex(key), value);
        });
        return newList;
    }
}
