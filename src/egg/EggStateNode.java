package egg;

import java.util.ArrayList;
import java.util.Random;

import model.StateNode;

public class EggStateNode extends StateNode{
	private boolean[][] board;
	public static int UP = -1;
	public static int DOWN = 1;
	public EggStateNode(int width, int height, int k) {
		super(width, height, k);
		board = new boolean[height][width];
		// TODO Auto-generated constructor stub
	}
	public void setBoard(boolean[][] board){
		this.board = board;
	}
	@Override
	public double eval() {
		double of = 0;
		int[] eggsInRow = new int[height];
		int[] eggsInCol = new int[width];
		int[] eggsInTopLeftDiag = new int[height+width -1];
		int[] eggsInTopRightDiag = new int[height+width -1];
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == true){
					eggsInRow[i]++;
					eggsInCol[j]++;
					eggsInTopLeftDiag[width -j + i - 1]++;
					eggsInTopRightDiag[i+j]++;
				}
			}
		}
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == true){
					if(eggsInRow[i] <= k && eggsInCol[j] <= k && eggsInTopLeftDiag[width -j + i - 1] <= k && eggsInTopRightDiag[i+j] <= k){
						of++;
					}
				}
			}
		}
		return of / (width*k);
	}

	@Override
	public ArrayList<StateNode> getNeighbours() {
		ArrayList<StateNode> neighbourList = new ArrayList<StateNode>();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == true){
					//Up
					EggStateNode newNodeUp = new EggStateNode(width,height,k);
					boolean[][] newBoardUp = generateNewBoard(j, i, UP);
					if(newBoardUp != null){
						newNodeUp.setBoard(newBoardUp);
						neighbourList.add(newNodeUp);
					}
					
					//Down
					EggStateNode newNodeDown = new EggStateNode(width,height,k);
					boolean[][] newBoardDown = generateNewBoard(j, i, DOWN);
					if(newBoardDown != null){
						newNodeDown.setBoard(newBoardDown);
						neighbourList.add(newNodeDown);
					}
				}
			}
		}
		return neighbourList;
	}
	private boolean[][] generateNewBoard(int eggX, int eggY,int dir){
		boolean[][] newBoard = new boolean[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				newBoard[i][j] = board[i][j];
			}
		}
		if((eggY+dir) < 0 || (eggY+dir) >= height){
			return null;
		}
		if(board[eggY + dir][eggX] == true){
			return null;
		}else{
			newBoard[eggY][eggX] = false;
			newBoard[eggY + dir][eggX] = true;
			return newBoard;
		}
		
	}
	public void generateInitialState(){
		Random r = new Random();
		for(int i = 0; i < width; i++){
			int placed = 0;
			while(placed < k){
				int rand = r.nextInt(height);
				if(board[rand][i] == false){
					board[rand][i] = true;
					placed++;
				}
			}
		}
	}
	public void printBoard(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				System.out.print(((board[i][j]) ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}

}
