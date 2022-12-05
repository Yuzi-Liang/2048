import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Date;

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
                int result = JOptionPane.showConfirmDialog(myf,"do you want to save game?", "Save Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                        GUIIntegration.this.invalidate();
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

    public Color getBackground(int value) {
        switch (value) {
            case 2:    return new Color(0xeee4da);
            case 4:    return new Color(0xede0c8);
            case 8:    return new Color(0xf2b179);
            case 16:   return new Color(0xf59563);
            case 32:   return new Color(0xf67c5f);
            case 64:   return new Color(0xf65e3b);
            case 128:  return new Color(0xedcf72);
            case 256:  return new Color(0xedcc61);
            case 512:  return new Color(0xedc850);
            case 1024: return new Color(0xedc53f);
            case 2048: return new Color(0xedc22e);
        }
        return new Color(0xcdc1b4);
    }

    public int getScore(){
        int score = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                score = score + gp.gameboard[i][j];
            }
        }

        return score;
    }
    @Override
    public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (gp.gameboard[i][j] != 0) {
                        g.setColor(getBackground(gp.gameboard[i][j]));
//                        g.fillRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength);
                        g.fillRoundRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength, 15,15);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("Arial", Font.BOLD, 20*4/size));
                        g.drawString(String.valueOf(gp.gameboard[i][j]), (int) (xoffset + j * blockDistance) + (int) blockSideLength / 2, (int) (yoffset + i * blockDistance) + (int) blockSideLength / 2);
                    } else {
                        g.setColor(getBackground(gp.gameboard[i][j]));
                        g.fillRoundRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength, 15,15);
//                        g.fillRect((int) (xoffset + j * blockDistance), (int) (yoffset + i * blockDistance), (int) blockSideLength, (int) blockSideLength);
                    }
                }
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Score: " + getScore(), 800, 50);
            g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            gp.goUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gp.goDown();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gp.goLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gp.goRight();
        }

        repaint();
        if(gp.isEnd()){
            String name = "s: ";
            while(name.contains(": ")) {
                name = JOptionPane.showInputDialog("Game ends, please name your game (don't include \"/ \" in name please)", null);
            }
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
                f.write(newLine + name + "/ " + score + "/ " + size + "/ "+ new Date());
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

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
