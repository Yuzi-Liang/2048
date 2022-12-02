import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
//        int[][] hello = new int[5][5];
//        for(int i = 0; i < hello.length; i++){
//            for(int j = 0; j < hello.length; j++){
//                hello[i][j] = 2;
//            }
//        }
        GUIIntegration gi = new GUIIntegration();
        GamePlay gp = new GamePlay(5);
        gp.gRB();
        gp.gRB();
        
        int[][] myb = gp.gameboard;
        
//        myb[0][0] = 4;
//        myb[1][0] = 4;
//        myb[2][0] = 2;
//        myb[3][0] = 4;
//        myb[4][0] = 4;
        
//        for(int k = 0; k < 10; k++) {
//	        for(int i = 0; i < gp.size; i++){
//	            for(int j = 0; j < gp.size; j++){
//	                System.out.print(gp.gameboard[i][j] + ", ");
//	            }
//	            System.out.println();
//	        }
//	        gp.goLeft();
//	        System.out.println();
//        }

        
    }
}
