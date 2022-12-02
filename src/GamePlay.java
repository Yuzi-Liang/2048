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
//    	System.out.println(ranNum);
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
    public boolean goUp(){
    	boolean canMove = false;
    	int[] currentCol = new int[size];
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentCol[k] = gameboard[k][i];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = 0; j < size; j++) {
				if(currentCol[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentCol[j] != 0 & !firstZero){
					currentCol[firstZeroLoc] = currentCol[j];
					currentCol[j] = 0;
					firstZeroLoc = firstZeroLoc + 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[k][i] = currentCol[k];
			}
		}	

		
		for(int i = 0; i < size-1; i++) {
			int[] currRow = gameboard[i];
			int[] nextRow = gameboard[i+1];
			for(int j = 0; j < size; j++) {
				if(currRow[j] == nextRow[j] & currRow[j] != 0) {
					currRow[j] = currRow[j]*2;
					nextRow[j] = 0;
					canMove = true;
				}
				
				
			}
			
		}
		
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentCol[k] = gameboard[k][i];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = 0; j < size; j++) {
				if(currentCol[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentCol[j] != 0 & !firstZero){
					currentCol[firstZeroLoc] = currentCol[j];
					currentCol[j] = 0;
					firstZeroLoc = firstZeroLoc + 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[k][i] = currentCol[k];
			}
		}	
		
		
		if(canMove) {
			this.gRB();
		}
		
		return canMove;
    	
	}
    
    public boolean goDown(){
    	boolean canMove = false;
    	int[] currentCol = new int[size];
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentCol[k] = gameboard[k][i];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = size - 1; j >= 0; j--) {
				if(currentCol[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentCol[j] != 0 & !firstZero){
					currentCol[firstZeroLoc] = currentCol[j];
					currentCol[j] = 0;
					firstZeroLoc = firstZeroLoc - 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[k][i] = currentCol[k];
			}
		}	

		
		for(int i = size - 1; i > 0; i--) {
			
			int[] currRow = gameboard[i];
			int[] nextRow = gameboard[i-1];
			for(int j = 0; j < size; j++) {
				if(currRow[j] == nextRow[j] & currRow[j] != 0) {
					currRow[j] = currRow[j]*2;
					nextRow[j] = 0;
					canMove = true;
				}
				
				
			}
			
		}
		
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentCol[k] = gameboard[k][i];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = size - 1; j >= 0; j--) {
				if(currentCol[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentCol[j] != 0 & !firstZero){
					currentCol[firstZeroLoc] = currentCol[j];
					currentCol[j] = 0;
					firstZeroLoc = firstZeroLoc - 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[k][i] = currentCol[k];
			}
		}	
		
		
		if(canMove) {
			this.gRB();
		}
		
		return canMove;
    	
	}
    
    public boolean goLeft(){
    	boolean canMove = false;
    	int[] currentRow = new int[size];
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentRow[k] = gameboard[i][k];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = 0; j < size; j++) {
				if(currentRow[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentRow[j] != 0 & !firstZero){
					currentRow[firstZeroLoc] = currentRow[j];
					currentRow[j] = 0;
					firstZeroLoc = firstZeroLoc + 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[i][k] = currentRow[k];
			}
		}	

		
		for(int i = 0; i < size-1; i++) {
			int[] currRow =new int[size];
			int[] nextRow = new int[size];
			for(int j = 0; j < size; j++) {
				currRow[j] = gameboard[j][i];
				nextRow[j] = gameboard[j][i+1];
			}
			
			for(int j = 0; j < size; j++) {
				if(currRow[j] == nextRow[j] & currRow[j] != 0) {
					currRow[j] = currRow[j]*2;
					nextRow[j] = 0;
					canMove = true;
				}
				
				
			}
			
			for(int j = 0; j < size; j++) {
				 gameboard[j][i] = currRow[j];
				 gameboard[j][i+1] = nextRow[j];
			}
			
			
			
			

			
		}
		
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentRow[k] = gameboard[i][k];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = 0; j < size; j++) {
				if(currentRow[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentRow[j] != 0 & !firstZero){
					currentRow[firstZeroLoc] = currentRow[j];
					currentRow[j] = 0;
					firstZeroLoc = firstZeroLoc + 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[i][k] = currentRow[k];
			}
		}	
		
		
		if(canMove) {
			this.gRB();
		}
		
		return canMove;
    	
	}
    
    public boolean goRight(){
    	boolean canMove = false;
    	int[] currentRow = new int[size];
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentRow[k] = gameboard[i][k];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = size - 1; j >= 0; j--) {
				if(currentRow[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentRow[j] != 0 & !firstZero){
					currentRow[firstZeroLoc] = currentRow[j];
					currentRow[j] = 0;
					firstZeroLoc = firstZeroLoc - 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[i][k] = currentRow[k];
			}
		}	

		
		for(int i = size - 1; i > 0; i++) {
			int[] currRow =new int[size];
			int[] nextRow = new int[size];
			for(int j = 0; j < size; j++) {
				currRow[j] = gameboard[j][i];
				nextRow[j] = gameboard[j][i-1];
			}
			
			for(int j = 0; j < size; j++) {
				if(currRow[j] == nextRow[j] & currRow[j] != 0) {
					currRow[j] = currRow[j]*2;
					nextRow[j] = 0;
					canMove = true;
				}
				
				
			}
			
			for(int j = 0; j < size; j++) {
				gameboard[j][i] = currRow[j];
				gameboard[j][i-1] = nextRow[j];
			}
			
			
			
			

			
		}
		
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				currentRow[k] = gameboard[i][k];
			}
//			currentCol = gameboard[i];
			boolean firstZero = true;
			int firstZeroLoc = 0;
			for(int j = size - 1; j >= 0; j--) {
				if(currentRow[j] == 0 & firstZero) {
					firstZero = false;
					firstZeroLoc = j;
				}
				else if(currentRow[j] != 0 & !firstZero){
					currentRow[firstZeroLoc] = currentRow[j];
					currentRow[j] = 0;
					firstZeroLoc = firstZeroLoc - 1;
					canMove = true;
				}
			}
			for(int k = 0; k < size; k++) {
				gameboard[i][k] = currentRow[k];
			}
		}	
		
		
		if(canMove) {
			this.gRB();
		}
		
		return canMove;
    	
	}

}
