package model.prisms;

import model.parents.Prism;
	/**
	 * Class of all Octagonal prisms
	 * @author Lenard
	 *
	 */
public class Octagonal extends Prism{
	/**
	 * Constructor of octagonals
	 * @param height
	 * @param edgeLength
	 */
	public Octagonal(double height, double edgeLength) {
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
		return (double) (2 * (1 + Math.sqrt(2)) * this.getEdgeLength() * this.getEdgeLength());
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
		return "OctagonalPrism: EdgeLength= " + getEdgeLength() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
	
	
	
}
