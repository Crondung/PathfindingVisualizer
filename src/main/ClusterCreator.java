package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClusterCreator {
	private static final String FILE_CONNECTED_TOWNS = "res/verb.txt";
	private List<Node> cluster = new ArrayList<Node>();
	private Map<List<String>, Integer> distances;

	public ClusterCreator() {
		distances = new TableParser().getCityToCityDistance();
		buildClusterByMap(getConnectedTowns());
	}

	public List<Node> getCluster() {
		return cluster;
	}

	/**
	 * reads verb.txt
	 * @return Map of Key=[String]originTown, Value = [List<String>] connectedTowns
	 */
	private Map<String, List<String> > getConnectedTowns() {
		Map<String, List<String> > AllTownConnectionsMap = new TreeMap<String, List<String> >();
		try {
			Scanner scanner = setupFileScannerFor(FILE_CONNECTED_TOWNS);
			List<String> currentTownConnections = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.isBlank()) {
					currentTownConnections.add(line);
				} else {
					//First element of currentTownConnections is the origin town, all other elements get connected to origin town
					AllTownConnectionsMap.put(currentTownConnections.remove(0), currentTownConnections);
					currentTownConnections = new ArrayList<String>();
				}
			}
			//needed to add last searchResult to Map
			AllTownConnectionsMap.put(currentTownConnections.remove(0), currentTownConnections);
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return AllTownConnectionsMap;
	}

	private Scanner setupFileScannerFor(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		return new Scanner(file);
	}
	
	private void buildClusterByMap(Map<String, List<String>> connectedTowns) {
		createTownNodesByMapKeys(connectedTowns);
		createConnectionsBetweenTownNodes(connectedTowns);
		String s = "";
	}

	private void createTownNodesByMapKeys(Map<String, List<String>> connectedTowns) {
		Iterator<?> iterator = connectedTowns.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			Node node = new Node(pair.getKey().toString());
			cluster.add(node);
		}
	}
	
	private void createConnectionsBetweenTownNodes(Map<String, List<String>> connectedTowns) {
		int positionInCluster = 0;
		Iterator<?> iterator = connectedTowns.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			List<String> connections = (List<String>)pair.getValue();
			Node currentTown = cluster.get(positionInCluster);
			for(String element : connections) {
				Node goToNode = getNodeByName(element);
				if(goToNode == null) {
					System.out.println("Couldn't find Town :" + element);
					return;
				}
				String townName = currentTown.getName();
				String toTownNome = goToNode.getName();
				boolean connectionContainedFlag = false;
				for (Connection connection : currentTown.getConnections()) {
					if(connection.getGoToNode().equals(goToNode)) {
						connectionContainedFlag = true;
					}
				}
				if(!connectionContainedFlag) {
					currentTown.addConnection(goToNode, distances.get(List.of(townName, toTownNome)));
				}
			}
			
			positionInCluster++;
			}
	}
	
	private Node getNodeByName(String name) {
		Iterator<?> iterator = cluster.iterator();
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			if(node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}

// read file etab.html
// create adjacency List
}
