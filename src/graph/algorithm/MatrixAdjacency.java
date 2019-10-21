package graph.algorithm;

import graph.control.VertexControl;
import util.control.IntegerControl;

/**
 * É uma matriz B quadrada de ordem N, onde N é o número de vértices do grafo É
 * uma matriz booleana (f/v ou 0/1): bij = 1 se o vértice i for adjacente ao
 * vértice j bij = 0 caso contrário
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class MatrixAdjacency {

    private final Integer[][] matrix;
    private final String[] vertexes;
    private final int size;

    public MatrixAdjacency(ListAdjacency list) {
        this.vertexes = VertexControl.getTags(list.getVertexes());
        this.size = vertexes.length;
        this.matrix = IntegerControl.getFilled(size, size, 0);
        fillMatrix(list);
    }
    
    private void fillMatrix(ListAdjacency list){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(list.isAdjacency(list.getVertexes().get(i), 
                        list.getVertexes().get(j))){
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public String[] getVertexes() {
        return vertexes;
    }
}
