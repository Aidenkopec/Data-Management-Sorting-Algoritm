package model.prisms;

import model.parents.Prism;
	/**
	 * Class of all Triangular Prisms
	 * @author Lenard
	 *
	 */
public class Triangular extends Prism{
	/**
	 * Constructor of triangular prism
	 * @param height
	 * @param edgeLength
	 */
	public Triangular(double height, double edgeLength) {
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
		return (double) ((this.getEdgeLength() * this.getEdgeLength() * Math.sqrt(3)) / 4);
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
		return "TrinagularPrism: EdgeLength= " + getEdgeLength() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
	
	

}
