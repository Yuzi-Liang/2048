import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ScoreBoardPanel extends JPanel {
    StartMenuPanel smp;
    JFrame myf;
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
        this.add(jb);
        this.setFocusable(true);
        this.setSize(1000, 600);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {

            FileReader rd = new FileReader("score.txt");
            BufferedReader reader = new BufferedReader(rd);
            int line = 0;
            String curr = reader.readLine();
            while(curr != null){
                g.drawString(curr, 300, 50 + line*50);
                curr = reader.readLine();
                line++;
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
