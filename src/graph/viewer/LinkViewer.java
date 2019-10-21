package graph.viewer;

import graph.Directable;
import graph.Link;

/**
 * Mostra todos os dados da classe Ligação ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class LinkViewer {

    public static String statusDirectable(Link link, Directable directable) {
        return "[LINK]\n[" + link.getTag() + "]   "
                + link.getVertex().getTag()
                + DirectableViewer.status(directable)
                + link.getAdjacent().getTag() + "custo: " + link.getCost();
    }

    public static String status(Link link) {
        return link.getTag() + " (" + link.getCost() + ")";
    }
}
