package model.prisms;

import model.parents.Prism;
	/**
	 * Class of all pentagonal prism shapes
	 * @author Lenard
	 *
	 */
public class Pentagonal extends Prism {
	/**
	 * Pentagonal shape constructor
	 * @param height
	 * @param edgeLength
	 */
	public Pentagonal(double height, double edgeLength) {
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
		return (double) (((5 * this.getEdgeLength() * this.getEdgeLength()) * Math.tan(54)) / 4);
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
		return "PentagonalPrism: EdgeLength= " + getEdgeLength() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
	
	
}
