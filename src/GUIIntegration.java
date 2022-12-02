import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIIntegration extends JFrame implements KeyListener{
    GamePlay gp;
    int size;
    double blockSideLength;
    double blockDistance;
    final double xoffset = 200;
    final double yoffset = 10;
    JPanel currentP = new JPanel();
    public GUIIntegration(){
//        this.gameboard = gameboard;
//        int size = gameboard.length;
//        blockSideLength = 500/size;
//        blockDistance = blockSideLength + 10;
    		this.addKeyListener(this);
    	  GMenu(currentP);
    	  this.add(currentP);
    	  this.setSize(1000, 600);
    	  this.setVisible(true);
    }
    

    public void GMenu(JPanel mp) {
//    	JPanel panel = new JPanel();
    	JButton button1 = new JButton("Start Game");
    	JButton button2 = new JButton("Load Game");
    	
    	button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String size = JOptionPane.showInputDialog(mp, "what size do you want?", null);
				GUIIntegration.this.size = Integer.parseInt(size);
				blockSideLength = 500/GUIIntegration.this.size;
		        blockDistance = blockSideLength + 10;
				GUIIntegration.this.gp = new GamePlay(GUIIntegration.this.size);
//				JPanel pastP = GUIIntegration.this.currentP;
				GUIIntegration.this.currentP.removeAll();
				GUIIntegration.this.currentP.revalidate();
				GUIIntegration.this.currentP.repaint();

				GamePlayPanel(GUIIntegration.this.currentP);
				GUIIntegration.this.add(currentP);
				GUIIntegration.this.setSize(1000, 600);
  		        GUIIntegration.this.setVisible(true);
			}
    		
    	});
    	mp.addKeyListener(this);
    	mp.add(button1);
    	mp.add(button2);
    	
    	
    	
    }
    
    
    
    
    
    
    
    public void GamePlayPanel(JPanel mp){
    	gp.gRB();
    	gp.gRB();
        mp.setLayout(null);
        JTextField[][] init = new JTextField[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(gp.gameboard[i][j] != 0){
                    init[i][j] = new JTextField();
                    init[i][j].setText(String.valueOf(gp.gameboard[i][j]));
                    init[i][j].setBounds((int)(xoffset+j*blockDistance), (int)(yoffset+i*blockDistance), (int)blockSideLength, (int)blockSideLength);
                    mp.add(init[i][j]);
                }else {
                	init[i][j] = new JTextField();
                	init[i][j].setBounds((int)(xoffset+j*blockDistance), (int)(yoffset+i*blockDistance), (int)blockSideLength, (int)blockSideLength);
                    mp.add(init[i][j]);
                }

            }
        }
        
        mp.revalidate();
        mp.addKeyListener(this);
        mp.setFocusable(true);
    	mp.requestFocusInWindow();
        mp.repaint();
//        this.add(panel);
//        this.remove(panel);
//        this.setSize(1000, 600);
//        this.setVisible(true);
    }










	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("in");
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			gp.goUp();
//			this.repaint();
			System.out.println("up");
		}
	}










	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("in");
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			gp.goUp();
			this.repaint();
			System.out.println("up");
		}
		
		
		
		
		
		
	}










	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}
