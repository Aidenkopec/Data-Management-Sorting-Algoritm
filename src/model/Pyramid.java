package model;

import model.parents.Shape;
/**
 * Class of pyramid shapes
 * @author Aiden
 *
 */
public class Pyramid extends Shape{
	private double edgeLength;
	/**
	 * Constructor of pyramid
	 * @param height
	 * @param edgeLength
	 */
	public Pyramid(double height, double edgeLength) {
		this.setHeight(height);
		this.setEdgeLength(edgeLength);
		setBaseArea(this.calcBaseArea());
		setVolume(this.calcVolume());
	}
	/**
	 * @return baseArea
	 */
	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return (double) (this.getEdgeLength() * this.getEdgeLength());
	}
	/**
	 * @return volume
	 */
	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return (double) ((this.getBaseArea()*this.getHeight())/3);
	}
	/**
	 * 
	 * @return edge
	 */
	public double getEdgeLength() {
		return edgeLength;
	}
	
	/**
	 * 
	 * @param edgeLength to set edge
	 */
	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}
	
	@Override
	public String toString() {
		return "Pyramid: EdgeLength= " + getEdgeLength() + " Volume= "
				+ getVolume() + " BaseArea= " + getBaseArea() + " Height= " + getHeight();
	}
	

}
