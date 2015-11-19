import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard extends JPanel{
		
	//	Brick temp = new Brick(40, 40, Color.RED);
		
		Container t = new Container();
		
		Slider s;
		
		int SLOWNESS = 10;
		
		int numberOfBricks = 16;
		
		Brick [] bricks = new Brick [numberOfBricks];
		
		Thread thread = new Thread();
		
		Ball ball;
		
		Integer score = 0;
		
		JLabel scoreLabel = new JLabel("Score : 0");
		
		int noOfActiveBricks = numberOfBricks;				// Would be useful in isWin Condition
		
		GameBoard()
		{
			super();
			setBounds(30, 30, 600, 600);
			initializeBoard();
	//		ball.moveTheBall();
	//		thread.start();
			Timer timer = new Timer();
	//		startTheGame();
	//		scoreLabel.setText(score.toString());
			timer.scheduleAtFixedRate(new myTask(), 200, SLOWNESS);
			
		//	score = (numberOfBricks - noOfActiveBricks) * 10;
			
			add(scoreLabel);
			
		//	Integer score1 = 0;
			
		//	String sc = score.toString();
		}
		
		private class myTask extends TimerTask{

			@Override
			public void run() {
				ball.moveTheBall();
				checkBallCollsion();
				repaint();
				checkWinCondition();
			}
			
		}
		
		public void checkWinCondition()
		{
			if(noOfActiveBricks == 0)
			{
				System.out.println("Player have won the game!!!");
				System.exit(1);
			}
		}
		
		public void addBricks()
		{
			int row = 0, starting_x = 110, starting_y = 40, index = 0;
			
			int heightOfBricks = 20, widthOfBricks = 45;
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 8; j++)
				{

					bricks[index] = new Brick((starting_x + (j * (widthOfBricks + 2))), (i * (heightOfBricks + 2)) + starting_y, Color.RED);
					System.out.println(starting_x + (j * (widthOfBricks + 2)));
					index ++;
				}
			}
		}
		/**
		 * This method will just add the required elements (Bricks, slider and ball) to board. 
		 */
		public void initializeBoard()
		{
			setFocusable(true);
			addKeyListener(new MyListener());		// add listener
			
			s = new Slider(160, 540);				// initialize slider
			addBricks();
			int ballInitalX = (int) ((Math.random() * 1000) % 600);
			ball = new Ball(ballInitalX, 150, 10);
			
			this.add(scoreLabel, 0, 0);
			
//			
		}
		
	
		public void paintComponent(Graphics g) {
				
				
			//	s.addKeyListener(new MyListener());
			   
				super.paintComponent(g);
			    Graphics2D graphics = (Graphics2D) g;
			    
			    drawSprites(graphics);
			    
//			    myWait();
			    
			    
			    
			    Toolkit.getDefaultToolkit().sync();
			    
			    
		}
		
		/**
		 * 
		 * This function would draw the board
		 */
		
		public void drawSprites(Graphics2D g)
		{
//			g.clearRect(130, 130, 200, 30);
			
			g.fill(s.getRectangleToDraw());
			
	//		g.fill(temp.getRectangleToDraw());
			
			g.fill(ball.getCircleToDraw());
			
	//		g.
			scoreLabel.setText("Score : "+score);
			
			g.drawString(score.toString(), 0, 0);
			
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
		//		 ball.moveTheBall();
		//		 repaint();
		    }
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				 System.out.println("Pressed!!!");
			}

		}
		
		public void checkBallCollsion(){
			int starting_x = s.getRectangleToDraw().x;
			int starting_y = s.getRectangleToDraw().y;
			int ending_x = 60, ending_y = 10;
			
			System.out.println(starting_x +"                ====== X ");
			// Check collision with the slider
			if(ball.getCircleToDraw().intersects(starting_x, starting_y, ending_x, ending_y))
			{
				System.out.println("Intersected!");
			//	System.exit(1);
			//	ball.setXDir(ball.getXDir()*-1);
				ball.setYDir(ball.getYDir()*-1);
			}
			
			// Check collision with all of the bricks
			for(int i = 0; i < bricks.length; i++)
			{
				if (ball.getCircleToDraw().intersects(bricks[i].getRectangleToDraw()))
				{
					bricks[i].destroy();
					ball.setYDir(ball.getYDir()*-1);
					noOfActiveBricks --;
					score += 5;
				}
				
		//		System.out.println(starting_x + (col * (widthOfBricks + 2)));
				//col ++;
			}
			
				
		}
		
		/**
		 * This function should be static as we may need it to be at class level for all the objects of the class.
		 * (Usefull when we need to convert it as a multi-player game)
		 */
		
		public static void gameLost()
		{
			System.out.println("Player have lost the game!!");
			System.exit(1);
		}

	
}
