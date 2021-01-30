package main;

public class Connection{
	private Node originNode;
	private Node goToNode;
	private int distance;
	public Connection(Node originNode, Node goToNode, int distance) {
		this.originNode = originNode;
		this.goToNode = goToNode;
		this.distance = distance;
	}

	public Node getOriginNode(){
		return originNode;
	}

	public Node getGoToNode(){
		return goToNode;
	}
	
	public int getDistance() 
	{
		return distance;
	}
	
	public Connection invertConnection() {
		return new Connection(this.goToNode, this.originNode, this.distance);
	}

}
