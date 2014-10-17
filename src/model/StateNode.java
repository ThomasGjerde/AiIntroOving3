package model;

import java.util.ArrayList;

public abstract class StateNode {
	public int sizeX;
	public int sizeY;
	public int k;
	public StateNode(int sizeX, int sizeY, int k){
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.k = k;
	}
	public abstract double eval();
	public abstract ArrayList<StateNode> getNeighbours();
}
