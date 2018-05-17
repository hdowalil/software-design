package solution.trainer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The purpose of this class is, that it will be able to contain every coordinate one time maximum.
 */
final class UniqueCoordinates {
	
	private Set<Coordinate> uniqueCoordinates = new HashSet<>();
	
	boolean isCoordinateAlreadyIncluded(Coordinate coord2Check) {
		return uniqueCoordinates.contains(coord2Check);
	}

	/**
	 * @param coordinates2Check
	 * @return will return true, if one of the coordinates2Check is already included in our collection
	 */
	boolean isAtLeastOneCoordinateAlreadyIncluded(Collection<Coordinate> coordinates2Check) {
		for (Coordinate coord : coordinates2Check) {
			if (isCoordinateAlreadyIncluded(coord)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @throws IllegalArgumentException if the coordinate is already in our collection
	 * @param newCoordinate
	 */
	void addOnlyWhenNotIncluded(Coordinate newCoordinate) {
		if (isCoordinateAlreadyIncluded(newCoordinate)) {
			throw new IllegalArgumentException("duplicate coordinate");
		}
		uniqueCoordinates.add(newCoordinate);
	}

	Collection<Coordinate> getUniqueCoordinates() {
		return uniqueCoordinates;
	}
}
