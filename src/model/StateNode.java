package model;

import java.util.ArrayList;
import java.util.Random;

public abstract class StateNode {
	public int width;
	public int height;
	public int k;
	public StateNode(int width, int height, int k){
		this.width = width;
		this.height = height;
		this.k = k;
	}
	public abstract double eval();
	public abstract ArrayList<StateNode> getNeighbours();
	
	public StateNode getRandomNeighBour(ArrayList<StateNode> neighBours){
		Random r = new Random();
		return neighBours.get(r.nextInt(neighBours.size()));
	}
}
