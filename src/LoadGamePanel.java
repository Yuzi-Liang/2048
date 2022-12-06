import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LoadGamePanel extends JPanel {
    StartMenuPanel smp;
    JFrame myf;
    JTable jt;
    JScrollPane jsp;
    String[][] data;

    public LoadGamePanel(StartMenuPanel smp, JFrame myf){
        this.smp = smp;
        this.myf = myf;
        this.setLayout(null);
        JButton jb = new JButton("exit");
        jb.setBounds(25, 25, 70, 30);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadGamePanel.this.smp.setVisible(true);
                LoadGamePanel.this.myf.remove(LoadGamePanel.this);
            }
        });
//        this.add(scrollPane);
        FileReader rd = null;
        String[] column = {"Name", "Current Score", "Game Size", "Save Date"};
        File folder = new File("record/");
        File[] listFiles = folder.listFiles();
        ArrayList<String> filenames = new ArrayList<>();
        for(int i = 0; i < listFiles.length; i++){
            if(listFiles[i].isFile()){
                if(listFiles[i].getName().endsWith(".txt")){
                    filenames.add(listFiles[i].getName());
                }
            }

        }
        String[][] currdata = new String[filenames.size()][4];
        int index = 0;
        for(String filename: filenames){

            try {
                FileReader fr = new FileReader("record/" + filename);
                BufferedReader br = new BufferedReader(fr);
                String curr = br.readLine();
                String[] numbers = curr.split(" ");
                int size = (int)Math.sqrt(numbers.length);
                currdata[index][0] = filename.substring(0, filename.length()-4);
                currdata[index][2] = String.valueOf(size);
                int[][] gameboard = new int[size][size];
                int idx = 0;
                int score = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        String temp = numbers[idx];
                        idx++;
                        score = score + Integer.parseInt(temp);
                    }
                }
                currdata[index][1] = String.valueOf(score);
                String date = br.readLine();
                currdata[index][3] = date;
                index++;
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch(IOException io){
                System.out.println("IOException");
            }

        }

        JTable jt = new JTable(currdata, column){
            public boolean editCellAt(int row, int column, java.util.EventObject e){
                return false;
            }
        };

        jt.setFocusable(false);
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2){
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    String filename = jt.getValueAt(row, column).toString();
                    try {
                        FileReader fr = new FileReader("record/" + filename+".txt");
                        BufferedReader br = new BufferedReader(fr);
                        String curr = br.readLine();
                        String[] numbers = curr.split(" ");
                        int size = (int)Math.sqrt(numbers.length);
                        int[][] gameboard = new int[size][size];
                        int index = 0;
                        for(int i = 0; i < size; i++){
                            for(int j = 0; j < size; j++){
                                String temp = numbers[index];
                                index++;
                                gameboard[i][j] = Integer.parseInt(temp);
                            }
                        }
                        GamePlay gp = new GamePlay(gameboard);
                        GUIIntegration mygui = new GUIIntegration(gp, LoadGamePanel.this.smp, LoadGamePanel.this.myf, false, filename);
                        LoadGamePanel.this.setVisible(false);
                        LoadGamePanel.this.myf.add(mygui);
                        mygui.setFocusable(true);
                        mygui.requestFocusInWindow();
//                        LoadGamePanel.this.invalidate();
                        LoadGamePanel.this.myf.remove(LoadGamePanel.this);

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch(IOException io){
                        System.out.println("IOException");
                    }
                }
            }
        });

        jt.setBounds(30, 40, 400, 300);
        JScrollPane jsp = new JScrollPane(jt);
        jsp.setBounds(200,50,614,505);

        this.add(jsp);
        this.add(jb);
        this.setSize(1000, 600);
        this.setVisible(true);
    }

}
