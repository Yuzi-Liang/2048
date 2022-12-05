import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args){
        JFrame myf = new JFrame();
        StartMenuPanel myp = new StartMenuPanel(myf);
        myf.add(myp);
        myf.setSize(1000, 700);
        myf.setVisible(true);

    }
}
