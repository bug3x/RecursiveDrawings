import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	private int refreshInterval = 1000; //milliseconds
	private int x_boundR = 1000;
	private int x_boundL = 0;
	private int y_boundT = -50;
	private int y_boundB = 500; 
	
	private int x_center = (x_boundR-x_boundL)/2;
	private int y_center = (y_boundT - y_boundB)/2;
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
		// concentricRings(350, 220, 100, g);
		//squares(260, 150, 250, g);
		// donut(300, 100, 0, 200, g);
		// clover(230, 160, 300, g);
		snowFlake(20, 220, 200,g);
	}

	public void concentricRings(int x, int y, int width, Graphics g) {
		g.setColor(Color.white);
		if(width < 0) {
			return;
		}
		else {
			g.drawOval(x, y, width, width);
			concentricRings(x +5 , y + 5, width - 10, g);
		}
	}

	public void clover(int x, int y, int width, Graphics g) {
		g.setColor(Color.white);
		if(width < 0) {
			return;
		}
		else {
			g.drawOval(x+200, y, width, width);
			clover(x + 30 , y + 200, width - 10, g);
			g.drawOval(x - 30, y, width, width);
			concentricRings(x +5 , y + 5, width - 10, g);
			g.drawOval(x, y-30, width, width);
			concentricRings(x +5 , y + 5, width - 10, g);
			g.drawOval(x, y+30, width, width);
			concentricRings(x + 10 , y + 5, width - 10, g);
		}
	}

	public void snowFlake(int len, int x1, int y1, Graphics g) {
		g.setColor(Color.cyan);
		if(len < 1) {
			return;
		}
		else {
			for(int i = 0; i < 6; i++) {
				int x2 = (int) (((len + x1) * Math.cos(x1)) * (i * Math.PI/3));
				int y2 = (int) (((len + y1) * Math.sin(y1)) * (i * Math.PI/3));
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	public void squares(int x, int y, int width, Graphics g) {
		g.setColor(Color.white);
		int initial = 250;
		if(width < 1) {
			return;
		}
		else if(width == initial){
			g.fillRect(x, y, width, width);
			squares(x + 50, y, width/3, g);
		}
		else {
			for(int i = 0; i < 6; i++) {
				g.fillRect(x, y, width, width);
			}
			squares(x - 20, y, width/3, g);
		}
	}

	int red = 0, green = 200, blue = 100;

	public void donut(int x, int y, int angle, int width, Graphics g) {
		g.setColor(Color.getHSBColor(x, angle, width));
		if(width < 0) {
			return;
		}
		else {
			g.drawArc(x, y, width, width, angle, angle+360);
			
			donut(x - 10, y - 3, angle+10, width-5, g);
		}
	}

	public void spiral(int x, int y, int angle, int width, Graphics g) {
		
	}

	public void binTree(int x1, int y1, int x2, int y2, int len, Graphics g) {

	}

	public static void main(String[] arg) {

		// find a way to run the constructor of the Driver class
		Driver d = new Driver(); // will this invoke a constructor?

	}
	
	public void randomColor(Graphics g) {
		//pass
	}
	
	// 1) add a Driver constructor
	public Driver() {
		JFrame frame = new JFrame("ArrayList stuff");
		frame.setSize(800, 600);
		frame.add(this);

		// this part makes sure the x button closes the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t.start();
		// make the frame show up
		frame.setVisible(true);

	}

	Timer t = new Timer(refreshInterval, this);

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
}
