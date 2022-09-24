package model.prisms;

import model.parents.Prism;
	/**
	 * Class of all square prisms
	 * @author Lenard
	 *
	 */
public class Square extends Prism{
	/**
	 * Constructor of Square prism
	 * @param height
	 * @param edgeLength
	 */
	public Square(double height, double edgeLength) {
		super(height, edgeLength);
		setBaseArea(this.calcBaseArea());
		setVolume(this.calcVolume());
	}
	/**
	 * 
	 * @return baseArea
	 */
	@Override
	public double calcBaseArea() {
		return (double) this.getEdgeLength() * this.getEdgeLength();
	}
	/**
	 * @return volume
	 */
	@Override
	public double calcVolume() {
		return (double) this.getBaseArea() * this.getHeight();
	}

	@Override
	public String toString() {
		return "SquarePrism: EdgeLength= " + getEdgeLength() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
	
	

}
