package greedyANDdp;

/*
 * 3. Write a program to implement Dijkstra’s algorithm for finding shortest distances from a given
vertex to all other vertices of a given graph.
  */

import java.util.*;

public class Dijkstra {

	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;

	private int V;
	List<List<Node> > adj;

	public Dijkstra(int V)
	{
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	public void dijkstra(List<List<Node> > adj, int src)
	{
		this.adj = adj;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		pq.add(new Node(src, 0));

		dist[src] = 0;

		while (settled.size() != V) {

			if (pq.isEmpty())
				return;

			int u = pq.remove().node;

			if (settled.contains(u))
				continue;
			settled.add(u);

			e_Neighbours(u);
		}
	}

	private void e_Neighbours(int u)
	{

		int edgeDistance = -1;
		int newDistance = -1;

		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);

			if (!settled.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;

				pq.add(new Node(v.node, dist[v.node]));
			}
		}
	}

	public void display(int source){
		System.out.println("The shorted path from node :");

		for (int i = 0; i < this.dist.length; i++)
			System.out.println(source + " to " + i + " is "
							+ this.dist[i]);
	}

}

class Node implements Comparator<Node> {

	public int node;
	public int cost;

	public Node() {}

	public Node(int node, int cost)
	{

		this.node = node;
		this.cost = cost;
	}

	@Override public int compare(Node node1, Node node2)
	{

		if (node1.cost < node2.cost)
			return -1;

		if (node1.cost > node2.cost)
			return 1;

		return 0;
	}
}
