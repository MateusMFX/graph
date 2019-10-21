package graph.control;

import graph.Link;
import graph.Vertex;

import java.util.List;

/**
 * Regra para validação de uma lista de ligações, ou conversões.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class LinkControl {

    public static String[] getTags(List<Link> links) {
        return links.stream()
                .map(link -> link.getTag())
                .sorted()
                .toArray(String[]::new);
    }

    public static Link getLink(List<Link> links, Vertex vertex, Vertex adjacent) {
        return links.stream()
                .filter(link -> link.getVertex().equals(vertex)
                && link.getAdjacent().equals(adjacent))
                .findFirst().get();
    }
}
