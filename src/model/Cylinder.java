package model;

import model.parents.Shape;
/**
 * Class of all cylinder shape
 * @author Aiden
 *
 */
public class Cylinder extends Shape {

	private double radius;
	/**
	 * Constructor class of cylinder
	 * @param height
	 * @param radius
	 */
	public Cylinder(double height, double radius) {
		this.setHeight(height);
		this.radius = radius;
		setBaseArea(this.calcBaseArea());
		setVolume(this.calcVolume());
	}
	/**
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * 
	 * @param radius to set radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return baseArea
	 */
	@Override
	public double calcBaseArea() {
		return (double) (Math.PI * (this.getRadius() * this.getRadius()));
	}
	/**
	 * @return volume
	 */
	@Override
	public double calcVolume() {
		return (double) (this.getBaseArea() * this.getHeight());
	}

	@Override
	public String toString() {
		return "Cylinder: Radius= " + getRadius() + " Volume= " + getVolume() + " BaseArea= " + getBaseArea() + " Height= "
				+ getHeight();
	}

}
