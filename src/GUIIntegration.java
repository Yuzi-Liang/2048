import javax.swing.*;
import java.awt.*;

public class GUIIntegration extends JFrame implements{
    int[][] gameboard;
    int size;
    double blockSideLength;
    double blockDistance;
    final double xoffset = 200;
    final double yoffset = 10;
    public GUIIntegration(int[][] gameboard){
        this.gameboard = gameboard;
        int size = gameboard.length;
        blockSideLength = 500/size;
        blockDistance = blockSideLength + 10;

    }

    public JPanel createGamePlayPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JTextField[][] init = new JTextField[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(gameboard[i][j] != 0){
                    init[i][j] = new JTextField();
                    init[i][j].setText(String.valueOf(gameboard[i][j]));
                    init[i][j].setBounds((int)(xoffset+j*blockDistance), (int)(yoffset+i*blockDistance), (int)blockSideLength, (int)blockSideLength);
                    panel.add(init[i][j]);
                }

            }
        }

        this.add(panel);
        this.setSize(1000, 600);
        this.setVisible(true);
    }




}
