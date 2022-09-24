package manager;

import java.util.Comparator;

import model.parents.Shape;
/**
 * Class for comparing volume
 * @author Aiden
 *
 * @param <E>
 */
public class VolumeCompare<E extends Shape> implements Comparator<E> {
	
	@Override
	public int compare(E s1, E s2) {
		return (int) Math.ceil(s1.getVolume() - s2.getVolume());
	}
}
