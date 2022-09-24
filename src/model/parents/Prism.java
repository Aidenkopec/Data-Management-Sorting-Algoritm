package model.parents;

/**
 * Class parent of all prisms
 * @author Aiden
 *
 */
public abstract class Prism extends Shape {
	private double edgeLength;
	
	/**
	 * Prism constructor setting the height, edge length, and sides
	 * @param height
	 * @param edgeLength
	 * @param sides
	 */
	public Prism(double height, double edgeLength) {
		super();
		this.setHeight(height);
		this.setEdgeLength(edgeLength);
		
	}
	/**
	 * 
	 * @return edgeLength
	 */
	public double getEdgeLength() {
		return edgeLength;
	}
	
	/**
	 * 
	 * @param edgeLength to set edgeLength
	 */
	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}



}
