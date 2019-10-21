package graph.algorithm;

import graph.Vertex;

public class WelshPowell {
  
    private ListAdjacency list;
    

    public WelshPowell(ListAdjacency list) {
        this.links = list.getLinks().stream().collect(Collectors.toList());
        this.visited = new ArrayList<>();
        this.toVisit = new Stack<>();
        this.type = list.getType();
        this.start = null;
    }
}
