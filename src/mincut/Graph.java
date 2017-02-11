package mincut;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Graph {

	private static final String EOL = System.getProperty("line.separator");
	
	private Map<Integer, Set<Integer>> vertices;
	private Set<Edge> edges;

	public Graph() {
		vertices = new HashMap<>();
		edges = new HashSet<>();
	}

	public void addVertex(int vertex) {
		if (!vertices.containsKey(vertex)) {
			vertices.put(vertex, new HashSet<>());
		}
	}

	public void addEdge(int src, int dst) {
		Edge edge = new Edge(src, dst);
		if (!edges.contains(edge)) {
			addVertex(src);
			addVertex(dst);
			edges.add(edge);
			vertices.get(src).add(dst);
			vertices.get(dst).add(src);
		}
	}

	public Set<Edge> minCut(int a, int b) {
		if (!vertices.containsKey(a) || !vertices.containsKey(b)) {
			return null;
		}
		Set<Edge> best = new HashSet<>();
		Set<Edge> current = new HashSet<>();

		Map<Integer, Set<Integer>> verticesCopy = new HashMap<>(vertices);
		Set<Edge> edgesCopy = new HashSet<>(edges);
		Random random = new Random();
		while(verticesCopy.size() > 2) {

		}
		
		return best;

	}

	@Override
	public String toString() {
		if (vertices.isEmpty()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[" + EOL);
		Iterator<Integer> iterator = vertices.keySet().iterator();
		while(iterator.hasNext()) {
			int vertex = iterator.next();
			builder.append(vertex + "={");
			Iterator<Integer> edgeIter = vertices.get(vertex).iterator();
			while(edgeIter.hasNext()) {
				builder.append(edgeIter.next());
				if (edgeIter.hasNext()) {
					builder.append(", ");
				}
			}
			builder.append("}" + EOL);
		}
		return builder.append("]").toString();
	}

	private static class Edge {

		private int src;
		private int dst;

		public Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Edge)) {
				return false;
			}
			Edge other = (Edge) obj;
			return other.src == src && other.dst == dst;
		}

		@Override
		public int hashCode() {
			int res = 17;
			res = 31 * res + src;
			res = 31 * res + dst;
			return res;
		}

		@Override
		public String toString() {
			return "src=" + src + ", dst=" + dst;
		}
	}
}
