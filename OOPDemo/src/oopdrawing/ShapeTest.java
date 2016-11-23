package oopdrawing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
//		Shape s1, s2;
//		s1 = new Square(new Point(100,100), 50);
//		s1.setColor(Color.RED);
//		s2 = new Circle(new Point(200,200), 50);
//		s2.setColor(Color.RED);
//		list.add(s1);
//		list.add(s2);
	}

	public static void main(String[] args) {
		ShapeTest f = new ShapeTest();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setTitle("OOP Demo");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private class Canvas extends JPanel implements MouseListener{
		boolean isLeftMouseDrag;
		boolean isRightMouseDrag;
		BufferedImage image;
		
		public Canvas(){
			setFocusable(true);
			addMouseListener(this); 
			image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);  // TYPE... anh trong suot
			Timer t = new Timer(50, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// lay toa do
					Point p = getMousePosition();
					// kt ngoai man hinh
					if(p != null){
						if(isLeftMouseDrag){
							Shape s = new Square(p, 10, Color.RED);
							list.add(s);
						}else if(isRightMouseDrag){
							Shape s = new Circle(p, 15, Color.BLUE);
							list.add(s);
						}
						repaint();
					}
					
				}
			});
			t.start();
			setLayout(null);
			JButton btnSave = new JButton("Save");
			add(btnSave);
			btnSave.setBounds(10, 10, 70, 20);
			btnSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ImageIO.write(image, "PNG", new File("myImage.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics myGraphics = image.createGraphics();
			for (Iterator<Shape> iterator = list.iterator(); iterator.hasNext();) {
				Shape shape = (Shape) iterator.next();
				shape.draw(myGraphics);
			}
			// de nguoi khac thay anh minh ve
			g.drawImage(image, 0, 0, null);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(SwingUtilities.isLeftMouseButton(e)){
				isLeftMouseDrag = true;
			}
			else if(SwingUtilities.isRightMouseButton(e)){
				isRightMouseDrag = true;
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(SwingUtilities.isLeftMouseButton(e)){
				isLeftMouseDrag = false;
			}
			else if(SwingUtilities.isRightMouseButton(e)){
				isRightMouseDrag = false;
			}
			
		}
	}

}
