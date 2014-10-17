package main;

import model.Temperature;
import egg.EggStateNode;
import egg.Search;

public class Main {
	public static void main(String[] args) {
		EggStateNode stateNode = new EggStateNode(10, 10, 3);
		Temperature temp = new Temperature(1000);
		stateNode.generateInitialState();
		//stateNode.printBoard();
		Search start = new Search(stateNode, temp);
		//System.out.println("Size: " + stateNode.getNeighbours().size());
	}
}
