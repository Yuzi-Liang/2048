import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StartMenuPanel extends JPanel {
    JFrame myf;
    public StartMenuPanel(JFrame myf){
        this.myf = myf;
        this.setLayout(null);
        JButton button1 = new JButton("Start Game");
        JButton button2 = new JButton("Load Game");
        JButton button3 = new JButton("check scoreboard");

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardPanel sbp = new ScoreBoardPanel(StartMenuPanel.this, StartMenuPanel.this.myf);
                myf.add(sbp);
                StartMenuPanel.this.setVisible(false);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size1 = -1;
                while(size1 > 10 || size1 < 2) {
                    String size = JOptionPane.showInputDialog("what size do you want? (size between 2 and 10)", null);
                    size1 = Integer.parseInt(size);
                }
                GamePlay gp = new GamePlay(size1);
                GUIIntegration mygui = new GUIIntegration(gp, StartMenuPanel.this, StartMenuPanel.this.myf, true, "");
                myf.add(mygui);
                StartMenuPanel.this.setVisible(false);
            }

        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadGamePanel lgp = new LoadGamePanel(StartMenuPanel.this, StartMenuPanel.this.myf);
                myf.add(lgp);
                StartMenuPanel.this.setVisible(false);
//                String name = JOptionPane.showInputDialog("Please enter file name you want to load", null);
//                if(name == null){
//                    return;
//                }
//                File file = new File("record/" + name+".txt");
//                if(!file.exists()){
//                    System.out.println("file does not exist");
//                }else{
//                    try {
//                        FileReader fr = new FileReader("record/" + name+".txt");
//                        BufferedReader br = new BufferedReader(fr);
//                        String curr = br.readLine();
//                        String[] numbers = curr.split(" ");
//                        System.out.println("matrix size: " + numbers.length);
//                        int size = (int)Math.sqrt(numbers.length);
//                        System.out.println("size: "+ size);
//                        int[][] gameboard = new int[size][size];
//                        int index = 0;
//                        for(int i = 0; i < size; i++){
//                            for(int j = 0; j < size; j++){
//                                String temp = numbers[index];
//                                index++;
//                                gameboard[i][j] = Integer.parseInt(temp);
//                            }
//                        }
//                        GamePlay gp = new GamePlay(gameboard);
//                        GUIIntegration mygui = new GUIIntegration(gp, StartMenuPanel.this, StartMenuPanel.this.myf);
//                        myf.add(mygui);
//                        StartMenuPanel.this.setVisible(false);
//                    } catch (FileNotFoundException ex) {
//                        throw new RuntimeException(ex);
//                    } catch(IOException io){
//                        System.out.println("IOException");
//                    }
//                }
            }
        });
        JLabel myimg = new JLabel(new ImageIcon("image/icon.png"));

        button1.setBounds(320, 50, 100, 30);
        button2.setBounds(450, 50, 100, 30);
        button3.setBounds(580, 50, 140, 30);
        myimg.setBounds(250, 80, 500, 500);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(myimg);
        this.setSize(1000,600);
        this.setVisible(true);

    }
}
