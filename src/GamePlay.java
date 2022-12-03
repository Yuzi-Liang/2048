import java.util.ArrayList;
import java.util.Stack;

public class GamePlay {
    int[][] gameboard;
    ArrayList<int[]> emptyboard;
    int size;
    int emptyCount;

    public GamePlay(int size){
        this.size = size;
        this.gameboard = new int[size][size];
        this.gRB();
        this.gRB();
    }
    public GamePlay(int[][] gameboard){
        this.size = gameboard.length;
        this.gameboard = gameboard;
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
        int[] currPos = emptyboard.get(ranNum);

        int val = Math.random() >= 0.9 ? 4 : 2;
        gameboard[currPos[0]][currPos[1]] = val;

    }
    public void resetGame() {

    }

    public boolean isEnd(){
        if(!isFull()){
            return false;
        }else {
            //row check
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size-1; j++){
                    if(this.gameboard[i][j] == this.gameboard[i][j+1]){
                        return false;
                    }
                }
            }

            //col check
            for(int col = 0; col < size; col++){
                for(int row = 0; row < size-1; row++){
                    if(this.gameboard[row][col] == this.gameboard[row+1][col]){
                        return false;
                    }
                }
            }

            return true;
        }
//        return !(goUp() | goRight() | goLeft() | goDown());

    }

    public boolean isFull(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(this.gameboard[i][j] == 0){
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


        for(int i = size - 1; i > 0; i--) {
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
