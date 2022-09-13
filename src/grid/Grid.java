package grid;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Grid extends JPanel implements Runnable, ActionListener{
	int[][] grid =  new int[40][40];
	int sizeX = 800;
	int sizeY = 600;
	
	
	
	public Grid() {
		this.setBackground(Color.black);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void run() {
		JFrame jeff = new JFrame("Grid"); // In the beginning, there was Jeff. (define frame window, with name of program.)
		ImageIcon icon = new ImageIcon("grass.png");
		
		
		jeff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Jeff has to go to sleep when it is time for bed. (make sure program closes on quit.)
		jeff.setResizable(false); // Jeff also was happy with his body size. (make sure you can not resize. messes with ball physics.)
		jeff.setSize(new Dimension(sizeX,sizeY)); // This is how big Jeff was! A growing  (er. maybe not ) boy.
		jeff.setVisible(true); //Jeff wanted people to see him. (set window to be visible)
		jeff.getGraphics(); //Jeff likes to pick his clothes. (initiate graphics.)
		int irvl = 15;
		int inc = 15;
		for(int j = 0; j< 10;j++) {
			for(int i = 0; i < 10;i++) {
				//System.out.println(i);
				
				//System.out.println(irvl);
				JButton b = new JButton(""+i+"");
				b.setBounds(irvl+45,inc,45,45);
				b.setSize(45,45);
				b.setIcon(icon);
				grid[0][i] = i;
				grid[j][0] = j;
				
				jeff.add(b);
				int x = j;
				int y = i;
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("["+x+","+y+"]");
					}
					
				});
				b.setVisible(true);
				irvl = irvl + 45;
				
			}
			inc = inc + 45;
			irvl = 15;
		}
		
		
			
		jeff.getContentPane().add(this); //this = JPanel, I presume.                 UNCERTAIN COMMENT.
		
		
		
		repaint();
		revalidate();
		
	}
	public void paint(Graphics gh) { //In the morning, Jeff has to get dressed for work.
		super.paint(gh); //paint the panel with the graphics.
		gh.setColor(Color.green); //initiate random color for the panel.
		drawLines(gh);
		
		
	}
	public void drawLines(Graphics gh) {
		int irvl = 15;
		//System.out.println(irvl);
		//gh.drawLine(400,0,400,600);
		for(int i = 0; i < 45 ; i ++) {
			gh.drawLine(0,irvl,800,irvl);
			gh.drawLine(irvl,0,irvl,600);
			
			
				irvl = irvl + 45;
			
		}
	}
	public static void main(String args[]) {
		System.out.println("Rise and Shine.");
		SwingUtilities.invokeLater(new Grid());
	}
}
