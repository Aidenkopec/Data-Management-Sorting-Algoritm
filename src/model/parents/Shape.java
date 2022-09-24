package model.parents;

import java.util.*;

/**
 * This is the parent class of all shapes, with all the compare methods for height, volume and base area.
 * @author Aiden
 *
 */
public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {
	private double volume;
	private double baseArea;
	private double height;
	
	public abstract double calcBaseArea();
	public abstract double calcVolume();
	
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * @return the baseArea
	 */
	public double getBaseArea() {
		return baseArea;
	}

	/**
	 * @param baseArea the baseArea to set
	 */
	public void setBaseArea(double baseArea) {
		this.baseArea = baseArea;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * compare height
	 * 
	 * @param s
	 * @return an integer
	 */
	@Override
	public int compareTo(Shape s) {
		if (this.getHeight() > s.getHeight()) {
			return 1;
		} else if (this.getHeight() < s.getHeight()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * compare volume
	 * 
	 * @param s1
	 * @param s2
	 * @return an integer
	 */
	@Override
	public int compare(Shape s1, Shape s2) {

		if (s1.getVolume() > s2.getVolume()) {
			return 1;
		} else if (s1.getVolume() < s2.getVolume()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * compare baseArea
	 * 
	 * @param s1
	 * @param s2
	 * @return an integer
	 */
	public int compareBaseArea(Shape s1, Shape s2) {

		if (s1.getBaseArea() > s2.getBaseArea()) {
			return 1;
		} else if (s1.getBaseArea() < s2.getBaseArea()) {
			return -1;
		} else {
			return 0;
		}
	}
}
