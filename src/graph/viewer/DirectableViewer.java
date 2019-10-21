package graph.viewer;

import graph.Directable;

/**
 * Mostra todos os dados da classe Direcional ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class DirectableViewer {

    public static String status(Directable directable) {
        return (directable.getClass() == Directable.Directed.class)
                ? "   ----->   "
                : "   -----   ";
    }

}
