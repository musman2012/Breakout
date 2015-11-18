

import javax.swing.JFrame;


public class BreakOutGame extends JFrame{

	public static void main(String[] a) {
	//	JPanel screenBottom = new JPanel();  
	 //   JFrame window = new JFrame();
//	    Container gameSession = window.getContentPane();
	   // gameSession.setLayout(Layou);
	    
		BreakOutGame mk = new BreakOutGame();
		
	    mk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    mk.setBounds(30, 30, 600, 600);			// (starting x, starting y, increase in x, y)
	    
	    
	    mk.add(new GameBoard());
	    mk.setVisible(true);
	   
	    
	 //   screenBottom.add(new Slider(0,0));
	//    gameSession.add(new Slider(140,140));
	//    gameSession.add(new Brick(40,40,Color.BLACK), BorderLayout.PAGE_START);
	 // 	window.add(screenBottom);
	    
	  }


}