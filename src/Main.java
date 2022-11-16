public class Main {
    public static void main(String[] args){
        int[][] hello = new int[5][5];
        for(int i = 0; i < hello.length; i++){
            for(int j = 0; j < hello.length; j++){
                hello[i][j] = 2;
            }
        }
        GUIIntegration gi = new GUIIntegration(hello);
    }
}
