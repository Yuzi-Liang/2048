import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayPanel extends JPanel implements KeyListener {
    GamePlay gp;
    int size;
    double blockSideLength;
    double blockDistance;
    final double xoffset = 200;
    final double yoffset = 10;

    public GamePlayPanel(GamePlay gp){
        this.gp = gp;
        this.size = gp.gameboard.length;
        blockSideLength = 500/this.size;
        blockDistance = blockSideLength + 10;
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(gp.gameboard[i][j] != 0){
                    g.drawString(String.valueOf(gp.gameboard[i][j]), (int)(xoffset+j*blockDistance) + (int)blockSideLength/2, (int)(yoffset+i*blockDistance) + (int)blockSideLength/2);
                    g.drawRect((int)(xoffset+j*blockDistance), (int)(yoffset+i*blockDistance), (int)blockSideLength, (int)blockSideLength);
                }
            }
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            gp.goUp();
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gp.goDown();
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gp.goLeft();
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gp.goRight();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
