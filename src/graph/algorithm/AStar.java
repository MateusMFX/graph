package graph.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import graph.City;
import graph.Link;
import graph.Vertex;
import graph.control.LinkControl;

public class AStar {
	ListAdjacency la;
	public void run(ListAdjacency list, String source, String target) {
		List<Vertex> path = new ArrayList<Vertex>();
		this.la = list;
		List<Vertex> vertices = list.getVertexes();
		Vertex targetVertex = vertices.stream()
				  .filter(vertex -> target.equals(vertex.getTag()))
				  .findAny()
				  .orElse(null);
		Vertex sourceVertex = vertices.stream()
				  .filter(vertex -> source.equals(vertex.getTag()))
				  .findAny()
				  .orElse(null);
		path.add(sourceVertex);
		for (Vertex v: vertices) {
			((City) v.getElement()).withHeuristic((City) targetVertex.getElement());
		}
		Vertex nearestNeighbor = null;
		Vertex workingVertex = sourceVertex;
		do {
			List<Vertex> neighbors = list.getNeighbors(workingVertex);
			nearestNeighbor = neighbors.get(0);
			for (Vertex n: neighbors) {
				if (n.equals(nearestNeighbor)) continue;
				Double currentDistance = getDistance(workingVertex, n);
				Double newDistance = getDistance(workingVertex, nearestNeighbor);
				if (currentDistance > newDistance) continue;
				nearestNeighbor = n;
			}
			path.add(nearestNeighbor);
			workingVertex = nearestNeighbor;
		} while (!nearestNeighbor.equals(targetVertex));
		System.out.println(path);
	}
	
	private Double getDistance(Vertex a, Vertex b) {
		Double distance = 0.0;
		List<Link> links = this.la.getLinks();
		Link linkAB = LinkControl.getLink(links, a, b);
		distance += linkAB.getCost() + (((City) b.getElement()).getHeuristic() * 100);
		return distance;
	}
}
