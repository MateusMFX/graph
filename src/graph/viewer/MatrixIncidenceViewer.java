package graph.viewer;

import graph.algorithm.MatrixAdjacency;
import graph.algorithm.MatrixIncidence;
import util.control.StringControl;

/**
 * Mostra todos os dados da classe Matriz de Incidência ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class MatrixIncidenceViewer {

    public static String status(MatrixIncidence matrix) {
        return "\n" + StringControl.matrixViewer(matrix.getMatrix(),
                matrix.getLinks(), matrix.getVertexes(), maxLength(matrix));
    }

    private static int maxLength(MatrixIncidence matrix) {
        int max = 0;
        for (int i = 0; i < matrix.getVertexes().length
                && i < matrix.getLinks().length; i++) {
            max = matrix.getVertexes()[i].length() > max
                    ? matrix.getVertexes()[i].length() : max;
            max = matrix.getLinks()[i].length() > max
                    ? matrix.getLinks()[i].length() : max;
        }
        return max;
    }

}
