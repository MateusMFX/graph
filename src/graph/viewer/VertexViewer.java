package graph.viewer;

import graph.Vertex;

import java.util.stream.Collectors;

/**
 * Mostra todos os dados da classe Vertex ao usuário.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class VertexViewer {

    /**
     * Status do objeto vértice, retorna o nome.
     *
     * @param vertex vértice que será demonstrado os status.
     * @return o dado no formato de string.
     */
    public static String status(Vertex vertex) {
        return vertex.getTag();
    }

}
