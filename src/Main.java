import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args){
        JFrame myf = new JFrame();
//        GUIIntegration gui = new GUIIntegration(new GamePlay(5));
        StartMenuPanel myp = new StartMenuPanel(myf);
        myf.add(myp);

//        myf.setLayout();
//        myf.add(new GUIIntegration(new GamePlay(5)));
        myf.setSize(1000, 600);
        myf.setVisible(true);

    }
}
