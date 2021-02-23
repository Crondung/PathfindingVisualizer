package main;

public class Main {

	public static void main(String[] args) {

		Dijkstra dijkstra = new Dijkstra();
		try {
			dijkstra.findWayBetween("Berlin", "Mannheim");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
