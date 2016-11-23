package oopdrawing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	private Color color;
	private String name;
	protected Point center;
	
	public Shape(String sName){
		name = sName;
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract void draw(Graphics g);

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
}
