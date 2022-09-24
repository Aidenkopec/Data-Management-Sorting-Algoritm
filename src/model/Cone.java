package model;

import model.parents.Shape;

/**
 * Cone class for cone shape
 * @author Aiden
 *
 */
public class Cone extends Shape{
	private double radius;
	
	/**
	 * Constructor class of Cone
	 * @param height
	 * @param radius
	 */
	public Cone(double height, double radius) {
		this.setHeight(height);
		this.radius = radius;
		setBaseArea(this.calcBaseArea());
		setVolume(this.calcVolume());
	}
	
	/**
	 * 
	 * @return the radius
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
		return (double) (this.getBaseArea() * (this.getHeight()/3));
	}
	
	@Override
	public String toString() {
		return "Cone: Radius= " + getRadius() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
}
