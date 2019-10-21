package graph.viewer;

import graph.algorithm.MatrixIncidence;
import util.control.StringControl;

/**
 * Mostra todos os dados da classe Matriz de Incidência ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class MatrixIncidenceViewer {

    public static String status(MatrixIncidence matrix) {
        return "\n"+ StringControl.matrixViewer(matrix.getMatrix(),
                        matrix.getLinks(), matrix.getVertexes(), 10);
    }

}
