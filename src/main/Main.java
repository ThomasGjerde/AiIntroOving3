package main;

import egg.EggStateNode;

public class Main {
	public static void main(String[] args) {
		EggStateNode stateNode = new EggStateNode(10, 10, 2);
		stateNode.generateInitialState();
		stateNode.printBoard();
		//System.out.println("Size: " + stateNode.getNeighbours().size());
	}
}
