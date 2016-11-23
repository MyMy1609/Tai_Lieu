package oopdrawing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ShapeTest extends JFrame {
	ArrayList<Shape> list;
	Canvas pnl;
	
	public ShapeTest() {
		list = new ArrayList<>();
		pnl = new Canvas();
		pnl.setPreferredSize(new Dimension(600, 600));
		setContentPane(pnl);
		pack();
		
		//Test Square, Circle
		Shape s1, s2;
		s1 = new Square(50, new Point(100,100));
		s1.setColor(Color.RED);
		s2 = new Circle(new Point(200,200), 50);
		s2.setColor(Color.RED);
		list.add(s1);
		list.add(s2);
	}

	public static void main(String[] args) {
		ShapeTest f = new ShapeTest();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setTitle("OOP Demo");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private class Canvas extends JPanel{

		public Canvas(){
			setFocusable(true);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Iterator<Shape> iterator = list.iterator(); iterator.hasNext();) {
				Shape shape = (Shape) iterator.next();
				shape.draw(g);
			}
		}
	}

}
