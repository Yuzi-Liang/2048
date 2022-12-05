import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ScoreBoardPanel extends JPanel {
    StartMenuPanel smp;
    JFrame myf;
    JTable jt;
    JScrollPane jsp;
    String[][] data;
    String[][] timeorder;
    public ScoreBoardPanel(StartMenuPanel smp, JFrame myf){
        this.smp = smp;
        this.myf = myf;
        this.setLayout(null);
//        JScrollPane scrollPane = new JScrollPane(this);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JButton jb = new JButton("exit");
        jb.setBounds(50, 50, 100, 50);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardPanel.this.smp.setVisible(true);
                ScoreBoardPanel.this.myf.remove(ScoreBoardPanel.this);
            }
        });
//        this.add(scrollPane);
        FileReader rd = null;
        String[] column = {"Name", "Score", "Game Size", "Date"};
        ArrayList<String[]> mydata = new ArrayList<>();
        try {
            rd = new FileReader("score.txt");
            BufferedReader reader = new BufferedReader(rd);
            String curr = reader.readLine();
            curr = reader.readLine();
            while(curr != null){
                String[] temp = curr.split("/ ");
                mydata.add(temp);
                curr = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException io){
            System.out.println(io);
        }
        String[][] data = new String[mydata.size()][4];
        int index = 0;
       for(String[] temp: mydata){
           data[index][0] = temp[0];
           data[index][1] = temp[1];
           data[index][2] = temp[2];
           data[index][3] = temp[3];
           index++;
       }
       this.data = data;
       String[] choices = {"Score", "Size", "Date"};
       JComboBox<String> jcb = new JComboBox<>(choices);
       jcb.setBounds(800, 50, 100, 50);
       jcb.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange() == ItemEvent.SELECTED){
//                   System.out.print(e.getItem());
                   if(e.getItem().toString().equals("Score")){
                       System.out.println("in");
                       Arrays.sort(ScoreBoardPanel.this.data, Comparator.comparingInt(ele -> Integer.parseInt(ele[1])));
                       ScoreBoardPanel.this.setLayout(null);
                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jt);
                       ScoreBoardPanel.this.jt = new JTable(data, column);
                       jt.setBounds(30, 40, 400, 300);

                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.jsp = new JScrollPane(ScoreBoardPanel.this.jt);
                       jsp.setBounds(200,50,614,505);

                       ScoreBoardPanel.this.add(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.setSize(1000,600);
                       ScoreBoardPanel.this.setVisible(true);
                   }else if(e.getItem().toString().equals("Size")){
                       System.out.println("in");
                       Arrays.sort(ScoreBoardPanel.this.data, Comparator.comparingInt(ele -> Integer.parseInt(ele[2])));
                       ScoreBoardPanel.this.setLayout(null);
                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jt);
                       ScoreBoardPanel.this.jt = new JTable(data, column);
                       jt.setBounds(30, 40, 400, 300);

                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.jsp = new JScrollPane(ScoreBoardPanel.this.jt);
                       jsp.setBounds(200,50,614,505);

                       ScoreBoardPanel.this.add(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.setSize(1000,600);
                       ScoreBoardPanel.this.setVisible(true);
                   }else if(e.getItem().toString().equals("Date")){
                       ScoreBoardPanel.this.setLayout(null);
                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jt);
                       ScoreBoardPanel.this.jt = new JTable(ScoreBoardPanel.this.timeorder, column);
                       jt.setBounds(30, 40, 400, 300);

                       ScoreBoardPanel.this.remove(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.jsp = new JScrollPane(ScoreBoardPanel.this.jt);
                       jsp.setBounds(200,50,614,505);

                       ScoreBoardPanel.this.add(ScoreBoardPanel.this.jsp);
                       ScoreBoardPanel.this.setSize(1000,600);
                       ScoreBoardPanel.this.setVisible(true);
                   }
               }
           }
       });

//       Arrays.sort(data, Comparator.comparingInt(ele -> Integer.parseInt(ele[2]))); //default score
        this.timeorder = new String[data.length][data[0].length];
       for(int i = 0; i < data.length; i++){
           for(int j = 0; j < data[0].length; j++){
               this.timeorder[i][j] = data[i][j];
           }
       }
       JTable jt = new JTable(data, column);
       this.jt = jt;
       jt.setBounds(30, 40, 400, 300);
       JScrollPane jsp = new JScrollPane(jt);
       jsp.setBounds(200,50,614,505);
       this.jsp = jsp;

       this.add(jsp);
       this.add(jb);
       this.add(jcb);
       this.setFocusable(true);
       this.setSize(1000, 600);
       this.setVisible(true);
    }
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        try {
//
//            FileReader rd = new FileReader("score.txt");
//            BufferedReader reader = new BufferedReader(rd);
//            int line = 0;
//            String curr = reader.readLine();
//            while(curr != null){
//                g.drawString(curr, 300, 50 + line*50);
//                curr = reader.readLine();
//                line++;
//            }
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
