import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class GUIIntegration extends JPanel implements KeyListener {
    static final String newLine = System.getProperty("line.separator");
    GamePlay gp;
    int size;
    double blockSideLength;
    double blockDistance;
    final double xoffset = 200;
    final double yoffset = 10;
    StartMenuPanel smp;
    JFrame myf;
    public GUIIntegration(GamePlay gp, StartMenuPanel smp, JFrame myf){
        this.myf = myf;
        this.smp = smp;
        this.gp = gp;
        this.size = gp.gameboard.length;
        blockSideLength = 500/this.size;
        blockDistance = blockSideLength + 10;
        this.setLayout(null);
        JButton jb = new JButton("exit");
        jb.setLayout(null);
        jb.setBounds(50,50, 100, 50);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(myf,"do you want to save game?", "test", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.NO_OPTION){
                    GUIIntegration.this.smp.setVisible(true);
                    GUIIntegration.this.myf.remove(GUIIntegration.this);
                }else if(result == JOptionPane.YES_OPTION){
                    String name = JOptionPane.showInputDialog("Please input a file name", null);
                    try {
                        FileWriter writer = new FileWriter(name+".txt");
                        BufferedWriter bw = new BufferedWriter(writer);
                        for(int i = 0; i < GUIIntegration.this.size; i++){
                            String curr = "";
                            for(int j = 0; j < GUIIntegration.this.size; j++){
                                curr = curr + GUIIntegration.this.gp.gameboard[i][j] + " ";
                            }
                            bw.write(curr);
                        }
                        bw.flush();
                        bw.close();
                        GUIIntegration.this.smp.setVisible(true);
                        GUIIntegration.this.myf.remove(GUIIntegration.this);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }

            }
        });
        this.add(jb);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setSize(1000, 600);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (gp.gameboard[i][j] != 0) {
                        g.drawString(String.valueOf(gp.gameboard[i][j]), (int) (xoffset + j * blockDistance) + (int) blockSideLength / 2, (int) (yoffset + i * blockDistance) + (int) blockSideLength / 2);
                        g.drawRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength);
                    } else {
                        g.drawRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength);
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
            if(gp.isEnd()){
                String name = JOptionPane.showInputDialog("Game ends, please name your game", null);
                int score = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        score = score + gp.gameboard[i][j];
                    }
                }
                String filename = "score.txt";
                try {
                    File fi = new File(filename);
                    System.out.println(fi.exists());
                    PrintWriter f = new PrintWriter(new FileOutputStream(filename, true));
                    f.write(newLine + name + ": " + score);
                    f.flush();
                    f.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                this.smp.setVisible(true);
                this.myf.remove(this);
                return;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gp.goDown();
            repaint();
            if(gp.isEnd()){
                String name = JOptionPane.showInputDialog("Game ends, please name your game", null);
                int score = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        score = score + gp.gameboard[i][j];
                    }
                }
                String filename = "score.txt";
                try {
                    File fi = new File(filename);
                    System.out.println(fi.exists());
                    PrintWriter f = new PrintWriter(new FileOutputStream(filename, true));
                    f.write(newLine + name + ": " + score);
                    f.flush();
                    f.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                this.smp.setVisible(true);
                this.myf.remove(this);
                return;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gp.goLeft();
            repaint();
            if(gp.isEnd()){
                String name = JOptionPane.showInputDialog("Game ends, please name your game", null);
                int score = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        score = score + gp.gameboard[i][j];
                    }
                }
                String filename = "score.txt";
                try {
                    File fi = new File(filename);
                    System.out.println(fi.exists());
                    PrintWriter f = new PrintWriter(new FileOutputStream(filename, true));
                    f.write(newLine + name + ": " + score);
                    f.flush();
                    f.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                this.smp.setVisible(true);
                this.myf.remove(this);
                return;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gp.goRight();
            repaint();
            if(gp.isEnd()){
                String name = JOptionPane.showInputDialog("Game ends, please name your game", null);
                int score = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        score = score + gp.gameboard[i][j];
                    }
                }
                String filename = "score.txt";
                try {
                    File fi = new File(filename);
                    System.out.println(fi.exists());
                    PrintWriter f = new PrintWriter(new FileOutputStream(filename, true));
                    f.write(newLine + name + ": " + score);
                    f.flush();
                    f.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                this.smp.setVisible(true);
                this.myf.remove(this);
                return;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
