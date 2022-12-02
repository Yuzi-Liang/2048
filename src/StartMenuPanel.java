import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuPanel extends JPanel {
    JFrame myf;
    public StartMenuPanel(JFrame myf){
        this.myf = myf;
        JButton button1 = new JButton("Start Game");
        JButton button2 = new JButton("Load Game");

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String size = JOptionPane.showInputDialog("what size do you want?", null);
                int size1 = Integer.parseInt(size);
                GamePlay gp = new GamePlay(size1);
                GUIIntegration mygui = new GUIIntegration(gp);
                myf.add(mygui);
                StartMenuPanel.this.setVisible(false);
            }

        });

        this.add(button1);
        this.add(button2);
        this.setSize(1000,600);
        this.setVisible(true);

    }
}
