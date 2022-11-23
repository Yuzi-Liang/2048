import java.lang.Math;
import java.util.ArrayList;

public class GamePlay {
    int[][] gameboard;
    ArrayList<int[]> emptyboard;
    int size;
    int emptyCount;

    public GamePlay(int size){
    	this.size = size;
        gameboard = new int[size][size];
//        for(int i = 0; i < size; i++) {
//        	for(int j = 0; j < size; j++) {
//        		gameboard[i][j] = 2;
//        	}
//        }
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
    
    
    

}
