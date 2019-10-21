package graph.viewer;

import graph.algorithm.MatrixAdjacency;
import util.control.StringControl;

/**
 * Mostra todos os dados da classe Matriz de Adjacência ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class MatrixAdjacencyViewer {

    public static String status(MatrixAdjacency matrix) {
        return "\n"+ StringControl.matrixViewer(matrix.getMatrix(),
                matrix.getVertexes(), matrix.getVertexes(), 10);
    }

}
