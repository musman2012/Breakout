import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class GameBoard extends JPanel{
		
		Brick temp = new Brick(40, 40, Color.RED);
		
		Container t = new Container();
		
		Slider s = new Slider(160,540);
	
		Brick [] bricks = new Brick [15];
		
		GameBoard()
		{
			super();
			initializeBoard();
//			panel.setFocusable(true);
//			
//			panel.addKeyListener(new KeyListener() {
//				
//                @Override
//                public void keyTyped(KeyEvent e) {}
//
//                @Override
//                public void keyReleased(KeyEvent e) {}
//                
//                @Override
//                public void keyPressed(KeyEvent e) {
//                    System.out.println("Pressed " + e.getKeyChar());
//                }
//            });
//		//	addKeyListener(new My_Listener());
		}
		
		public void addBricks()
		{
			int row = 0, starting_x = 40, starting_y = 40, col = 0;
			
			int heightOfBricks = 20, widthOfBricks = 45;
			
			for(int i = 0; i<bricks.length; i++)
			{
				col = i;
				bricks[i] = new Brick(starting_x + (col * widthOfBricks), (row * heightOfBricks) + starting_y, Color.RED);
				if (i==9)
				{
					col = 1;
					row += 1;
				}
			}
		}
		
		public void initializeBoard()
		{
			setFocusable(true);
			addKeyListener(new MyListener());
			
			addBricks();
			
			
			
//			addKeyListener(new KeyListener() {
//				
//				@Override
//				public void keyTyped(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void keyReleased(KeyEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Awlaa");
//				}
//				
//				@Override
//				public void keyPressed(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			
		}
		
		public void myWait(){
			for (int i = 0; i < 99999999; i++);
		}
		
		public void paintComponent(Graphics g) {
				
				
			//	s.addKeyListener(new MyListener());
			   
				super.paintComponent(g);
			    Graphics2D graphics = (Graphics2D) g;
			    
			    drawSprites(graphics);
			    
//			    myWait();
			    
			    
			    
			    Toolkit.getDefaultToolkit().sync();
			    
			    
		}
		
		public void drawSprites(Graphics2D g)
		{
//			g.clearRect(130, 130, 200, 30);
			
			g.fill(s.getRectangleToDraw());
			
			g.fill(temp.getRectangleToDraw());
			
			for(int i = 0; i<bricks.length; i++)
			{
				g.fill(bricks[i].getRectangleToDraw());
			}
			
			
		}

		private class MyListener implements KeyListener {

			 @Override
			public void keyReleased(KeyEvent e)
			{
				System.out.println("Pressed!!!");
		//		s.move(e);
				
		//		repaint();
				// call the method of slider here
			}
			 @Override
			public void keyPressed(KeyEvent e) 
			{
				 System.out.println("Pressed!!!");
				 s.move(e);
				 repaint();
		    }
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				 System.out.println("Pressed!!!");
			}

		}
	
}
