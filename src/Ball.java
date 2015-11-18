import java.awt.Rectangle;
import java.awt.geom.*;;

public class Ball {
	
	private int starting_x, starting_y, diameter;

	Ball()
	{
		starting_x = 100;
		starting_y = 100;
		diameter = 10;
	}
	Ball(int x, int y, int diameter)
	{
		starting_x = x;
		starting_y = y;
		this.diameter = diameter;
	}
	public Ellipse2D getCircleToDraw()
	{
		Ellipse2D.Double ball = new Ellipse2D.Double();
		ball.height = diameter;
		ball.width = diameter;
		ball.x = starting_x;
		ball.y = starting_y;
		
		return ball;
	}
	
}
