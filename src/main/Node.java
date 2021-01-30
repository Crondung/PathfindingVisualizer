package main;

import java.util.HashSet;
import java.util.Set;

public class Node implements Comparable<Node>{
	
	private String name;
	private Set<Connection> connections = new HashSet<Connection>();
	private int value = Integer.MAX_VALUE;
	private Node previous;
	public Node(String name) {
		this.name = name;
	}
	private boolean visited = false;

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getPrevious(){
		return previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int newValue){
		value = newValue;
	}

	public String getName() {
		return name;
	}
	public Set<Connection> getConnections() {
		return connections;
	}

	//TODO abfragen ob Connection schon existent
	public void addConnection(Node goToNode, int distance) {
		//add connections in both ways cuz we dont have directed edges
		Connection connection = new Connection(this, goToNode, distance);
		connections.add(connection);
		goToNode.getConnections().add(connection.invertConnection());
	}

	@Override
	public int compareTo(Node node) {
		return this.value > node.value ? 1 : this.value < node.value ? -1 : 0;
	}
}
