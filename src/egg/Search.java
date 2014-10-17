package egg;

import java.util.ArrayList;

import model.StateNode;
import model.Temperature;

public class Search {
	
	//Best eval this far
	public double mEval = 0;
	
	//Holder for the init node
	public StateNode firstNode;
	
	//Holder for the init temperature
	public Temperature firstTemp;
	
	//Holder for the potential nextNode eval
	public double nextNodeEval;
	
	//Holder for the currentNode eval
	public double currentNodeEval;
	
	public Search(StateNode initNode, Temperature temp){
		firstNode = initNode;
		firstTemp = temp;
		//Starts the search
		performSearch(firstNode, firstTemp);
	}
	
	//Perfroms the search, starting with the initNode and the user given temperature
	public StateNode performSearch(StateNode initNode, Temperature temp){
		StateNode currentNode = initNode;
		double currentTemp = temp.temperature;
		
		while(currentTemp > 0){
			//Returns the currentNode if a solution is reached
			if(currentNode.eval() == 1){
				return currentNode;
			}
			
			
			ArrayList<StateNode> neighBours = new ArrayList<StateNode>();
			currentTemp = temp.currentTemp();
			neighBours = currentNode.getNeighbours();
			StateNode nextNode = getNextNode(neighBours);
			currentNodeEval = currentNode.eval();
			
			//denne trenger vi
			if(mEval < nextNodeEval){
				mEval = nextNodeEval;
			}//denne er jeg ikke sikker på om vi trenger, sjekken i starten tar seg av dette?
			if(mEval == 1){
				return currentNode;
			}
			
			double q = ((mEval - currentNodeEval) / currentNodeEval);
			double p = Math.min(1.0, Math.exp((-q) / currentTemp));
			double x = Math.random();
			
			if(x>p){
				currentNode = nextNode;
			}else{
				currentNode = currentNode.getRandomNeighBour(neighBours);
			}
			
		}
		return currentNode;
	}
	
	public StateNode getNextNode(ArrayList<StateNode> neighBours){
		StateNode nextNode = null;
		double bestEval = 0;
		
		
		for(int i=0; i<neighBours.size(); i++){
			double mid = neighBours.get(i).eval();
			if(mid > bestEval){
				bestEval = mid;
				nextNode = neighBours.get(i);
			}
		}
		nextNodeEval = bestEval;
		return nextNode;
	}
}
