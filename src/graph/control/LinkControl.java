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
    	Link targetLink = null;
    	for (Link link: links) {
    		if (link.getVertex().equals(vertex) && link.getAdjacent().equals(adjacent)) {
    			targetLink = link;
    			break;
    		}
    		if (link.getVertex().equals(adjacent) && link.getAdjacent().equals(vertex)) {
    			targetLink = link;
    			break;
    		}
    	}
    	return targetLink;
    }
}
