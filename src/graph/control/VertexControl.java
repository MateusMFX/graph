package graph.control;

import graph.Vertex;

import java.util.List;

/**
 * Regra para validação de uma lista de vértices, ou conversões.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class VertexControl {

    /**
     * Verifica a possibilidade de ter duplicata se inserir a vertex na lista.
     *
     * @param vertexes a lista a ser verificada
     * @param vertex a vertice que será checada na lista se já exista outra com
     * o mesmo nome.
     * @return true caso encontre uma vertice com o mesmo nome, falso caso não
     * encontre.
     */
    public static boolean canDuplicate(List<Vertex> vertexes, Vertex vertex) {
        return vertexes.stream()
                .anyMatch(v -> v.getTag().equals(vertex.getTag()));
    }

    /**
     * Verifica a possibilidade de ter uma laço ao inserir como ajacente a
     * vértice com o mesmo nome.
     *
     * @param vertex a vertice que vai receber o adjacente
     * @param adjacent a vertice que será inserida na lista de adjacência.
     * @return true caso crie um laço, caso contrário false.
     */
    public static boolean canLoop(Vertex vertex, Vertex adjacent) {
        return vertex.equals(adjacent);

    }
    
    public static String [] getTags(List<Vertex> vertexes){
        return vertexes.stream()
                .map(vertex -> vertex.getTag())
                .sorted()
                .toArray(String[]::new);
    }
}
