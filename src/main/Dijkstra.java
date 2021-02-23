package main;

import mapVisualizer.DijkstraSingleton;

import java.util.*;

public class Dijkstra {

    List<Node> cluster;
    List<Node> queue = new ArrayList<>();
    List<Node> processedNodes = new ArrayList<>();
    String destination;
    String startCity;
    Stack<Node> iKnoDaWay = new Stack();
    List<Node> debugList = new ArrayList<>();

    DijkstraSingleton updater;

    public Dijkstra(){
        this.cluster = new ClusterCreator().getCluster();
    }

    public Dijkstra(DijkstraSingleton dijkstraSingleton) {
        this.cluster = new ClusterCreator().getCluster();
        this.updater = dijkstraSingleton;
    }

    public void findWayBetween(String startCity, String destinationCity) throws InterruptedException {
        this.destination = destinationCity;
        this.startCity = startCity;
        if(!inputValid(startCity, destinationCity)) return;
        Node startNode = getCityFromCluster(startCity);
        startNode.setValue(0);
        queue.add(startNode);
        findShortestWay();
        fillWayStack(getCityFromCluster(destinationCity));
        printResult();
    }

    public List<Node> getProcessedNodes() {
        return processedNodes;
    }

    private boolean inputValid(String startCity, String destinationCity) {
      return  checkIfTownExists(startCity) && checkIfTownExists(destinationCity);
    }
    
    private boolean checkIfTownExists(String name) {
    	if(getCityFromCluster(name) != null) {
    		return true;
    	};
    	System.out.println("Your entered town " + name + " doesn't extist!");
    	return false;
    }
    
    private void printResult() {
    	System.out.println("Drive in this order: ");
        ListIterator<Node> wayIterator = iKnoDaWay.listIterator();
        while(wayIterator.hasNext()){
            System.out.println(iKnoDaWay.pop().getName());
        }
        Node destinationNode = getCityFromCluster(destination);
        System.out.println("Total distance: "+ destinationNode.getValue() + "km");
    }

    private void fillWayStack(Node node){
        if(node.getName().equals(startCity)){
            iKnoDaWay.push(node);
        }else{
            iKnoDaWay.push(node);
            fillWayStack(node.getPrevious());
        }
    }

    private void findShortestWay(){
        Collections.sort(queue);
        try {

            Node firstNode = queue.remove(0);
            if(!processedNodes.contains(firstNode)) processedNodes.add(firstNode);
            debugList.add(firstNode);
            if (updater!=null) {
                Thread.sleep(1000);
                updater.updatePaths();
            }
            calculateShortestDistance(firstNode);
            if (!queue.isEmpty()) {
                findShortestWay();
            }
        }catch (NullPointerException | InterruptedException e){
            e.printStackTrace();
        }

    }

    private void calculateShortestDistance(Node node){
        node.setVisited(true);
        List<Connection> connections = new ArrayList(node.getConnections());
        for(Connection connection : connections){
            Node goToNode = connection.getGoToNode();
            if(!goToNode.isVisited()) {
                if ((node.getValue() + connection.getDistance() < goToNode.getValue()) ||
                        (goToNode.getValue() == Integer.MAX_VALUE)) {
                    goToNode.setPrevious(node);
                    goToNode.setValue(connection.getDistance() + node.getValue());
                    queue.add(goToNode);
                }
            }
        }
    }

    private Node getCityFromCluster(String city){
        for(Node cityNode : cluster){
            if(cityNode.getName().equals(city)){
                return cityNode;
            }
        }
        return null;
    }

}
