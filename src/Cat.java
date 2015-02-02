import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - no one needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 10;
	private static final int EYE_WIDTH = 10;
	//legs
	private static final int LEG_Y = HEAD_DIMENSION-15;
	private static final int LEG_X = HEAD_DIMENSION/4+3;
	private static final int LEG_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int LEG_HEIGHT = 50;
	private static final int LEG_WIDTH = 15;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	//
	private static final int EAR_Y1 = HEAD_DIMENSION;
	private static final int EAR_Y2 = HEAD_DIMENSION/4;
	private static final int EAR_X1 = HEAD_DIMENSION;
	private static final int EAR_X2 = HEAD_DIMENSION/7*3;
	private static final int WHISK_X1 = HEAD_DIMENSION/5;
	private static final int WHISK_X2 = HEAD_DIMENSION/5*2;
	private static final int WHISK_Y1 = MOUTH_Y+HEAD_DIMENSION/2;
	private static final int WHISK_Y2 = MOUTH_Y+HEAD_DIMENSION/3;
	private static final int WHISK_Y3 = MOUTH_Y+HEAD_DIMENSION*2/3;

	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.black);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw Ears
		int[] earX = {EAR_X1, HEAD_DIMENSION - EAR_X2, HEAD_DIMENSION - EAR_X2};
		int[] earY = {EAR_Y1, EAR_Y1, EAR_Y2 };
		g2.setColor(Color.black);
		g2.fillPolygon(earX, earY, 3);
		earX[1] = EAR_X2 + HEAD_DIMENSION;
		earX[2] = earX[1];
		g2.fillPolygon(earX, earY, 3);
		// Draw the eyes
		g2.setColor(Color.red);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		//Draw legs
		g2.setColor(Color.black);
		x = catX + LEG_X; 
		y = catY + LEG_Y;
		g2.fillOval(x, y, LEG_WIDTH, LEG_HEIGHT);
		x += LEG_SEPARATION;
		g2.fillOval(x, y, LEG_WIDTH, LEG_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		// Draw whiskers
		g2.setColor(Color.darkGray);
		g2.drawLine(HEAD_DIMENSION+WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION+WHISK_X2, WHISK_Y1);
		g2.drawLine(HEAD_DIMENSION+WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION+WHISK_X2, WHISK_Y2);
		g2.drawLine(HEAD_DIMENSION+WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION+WHISK_X2, WHISK_Y3);
		g2.drawLine(HEAD_DIMENSION-WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION-WHISK_X2, WHISK_Y1);
		g2.drawLine(HEAD_DIMENSION-WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION-WHISK_X2, WHISK_Y2);
		g2.drawLine(HEAD_DIMENSION-WHISK_X1, catY + MOUTH_Y, HEAD_DIMENSION-WHISK_X2, WHISK_Y3);
		
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);	
	}
}
