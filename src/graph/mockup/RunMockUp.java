package graph.mockup;

import graph.ParanaState;
import graph.algorithm.AStar;


/**
 *
 * @author Administrator
 */
public class RunMockUp {

    public static void main(String[] args) {
        ParanaState mock = new ParanaState();
        AStar astar = new AStar();
        astar.run(mock.getListAdjacency(), "Umu", "Cur");
    }    
}
