package oopdrawing;
import java.awt.Graphics;
import java.awt.Point;

public class Square extends Shape {
	private Point location;
	private int sideWidth;

	public Square(int sideWidth, Point center) {
		super("Square");
		this.location = center;
		this.sideWidth = sideWidth;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point center) {
		this.location = center;
	}

	public int getSideWidth() {
		return sideWidth;
	}

	public void setSideWidth(int sideWidth) {
		this.sideWidth = sideWidth;
	}

	@Override
	public double getArea() {
		return sideWidth * sideWidth;
	}

	@Override
	public double getPerimeter() {
		return sideWidth * 4;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		int cornerX = location.x - (sideWidth / 2);
		int cornerY = location.y - (sideWidth / 2);
		g.drawRect(cornerX, cornerY, sideWidth, sideWidth);
	}

}
