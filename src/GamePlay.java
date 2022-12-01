import java.lang.Math;
import java.util.ArrayList;
import java.util.Stack;

public class GamePlay {
    int[][] gameboard;
    ArrayList<int[]> emptyboard;
    int size;
    int emptyCount;

    public GamePlay(int size){
    	this.size = size;
        gameboard = new int[size][size];
    }

    public void gRB() {
    	emptyboard = new ArrayList<>();
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			if(gameboard[i][j] == 0) {
    				int[] pos = {i,j};
    				emptyboard.add(pos);
    			}
    		}
    	}
    	int ranNum = (int)(Math.random()*emptyboard.size());
    	System.out.println(ranNum);
    	int[] currPos = emptyboard.get(ranNum);
    	
    	int val = Math.random() >= 0.9 ? 4 : 2;
    	gameboard[currPos[0]][currPos[1]] = val;
    	
    }
    public void resetGame() {
    	
    }

	public boolean isEnd(){
		if(!isFull()){
			return false;
		}else{
			Stack<Integer> myStack = new Stack<>();
			for(int i = 0; i < size; i++){
				myStack.clear();
				int currentIdx = 0;
				myStack.push(gameboard[i][currentIdx]);
				while(currentIdx+1 < size){
					int currVal = myStack.peek();
					if(currVal == gameboard[i][currentIdx+1]){
						return false;
					}else{
						myStack.pop();
						currentIdx = currentIdx + 1;
						myStack.push(gameboard[i][currentIdx]);
					}
				}

			}

			for(int i = 0; i < size; i++){
				myStack.clear();
				int currentIdx = 0;
				myStack.push(gameboard[currentIdx][i]);
				while(currentIdx+1 < size){
					int currVal = myStack.peek();
					if(currVal == gameboard[currentIdx+1][i]){
						return false;
					}else{
						myStack.pop();
						currentIdx = currentIdx + 1;
						myStack.push(gameboard[currentIdx][i]);
					}
				}

			}

			return true;
		}

	}




	public boolean isFull(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(gameboard[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
    public void goUp(){
		int currentRow = 0;
		int currentCol = 0;
		while(currentRow < gameboard.length-1){
			boolean nextRow = true;
			for(int i = 0; i < currentCol; i++){
				if(gameboard[currentRow][currentCol] == gameboard[currentRow+1][currentCol]){
					
				}
			}
		}
	}
    

}
