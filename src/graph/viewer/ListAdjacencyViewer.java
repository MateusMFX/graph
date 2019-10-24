package graph.viewer;

import graph.algorithm.ListAdjacency;
import graph.Vertex;

import java.util.stream.Collectors;

/**
 * Mostra todos os dados da classe Lista de adjacência ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class ListAdjacencyViewer {

    public static String status(ListAdjacency listAdjacency) {
        return "\n" + listAdjacency.getVertexes().stream()
                .sorted()
                .map(vertex -> "[" + vertex.getTag() + "]"
                + statusAdjacents(listAdjacency, vertex))
                .collect(Collectors.joining("\n"));

    }

    public static String statusAdjacents(ListAdjacency list, Vertex vertex) {
        return list.getList().get(vertex).stream()
                .sorted()
                .map(adjacent -> DirectableViewer.status(list.getType())
                + adjacent.getTag())
                .collect(Collectors.joining());
    }

}
