package cs3114.J2.Client;
import cs3114.J2.DS.Compare2D;
import cs3114.J2.DS.Direction;

public class Point implements Compare2D<Point> {

	private long xcoord;
	private long ycoord;

	public Point() {
		xcoord = 0;
		ycoord = 0;
	}

	public Point(long x, long y) {
		xcoord = x;
		ycoord = y;
	}

	// Returns the x-coordinate field of the user data object.
	/**
	 * gets the x coordinate of the point
	 */
	public long getX() {
		return xcoord;
	}

	// Returns the y-coordinate field of the user data object.
	/**
	 * gets the y coordinate of the point.
	 */
	public long getY() {
		return ycoord;
	}

	// Returns indicator of the direction to the user data object from the
	 // location (X, Y) specified by the parameters.
	 // The indicators are defined in the enumeration Direction, and are used
	 // as follows:
	 //
	 // NE: vector from (X, Y) to user data object has a direction in the
	 // range [0, 90) degrees (relative to the positive horizontal axis
	 // NW: same as above, but direction is in the range [90, 180)
	 // SW: same as above, but direction is in the range [180, 270)
	 // SE: same as above, but direction is in the range [270, 360)
	 // NOQUADRANT: location of user data object is equal to (X, Y)
	 //

	public Direction directionFrom(long X, long Y) {
		
		long distanceX = this.xcoord - X;
		long distanceY = this.ycoord - Y;
		Direction store;
		
		if (X == this.xcoord && Y == this.ycoord) {
			return Direction.NOQUADRANT;
		} 
		
		if (distanceX >= 0) {
			if (distanceY >= 0) {
				store = Direction.NE;
				return store;
			} else {
				store = Direction.SE;
				return store;
			}
		} else {
			if (distanceY >= 0) {
				store = Direction.NW;
				return store;
			} else {
				store = Direction.SW;
				return store;
			}
		}
	}

	// Returns indicator of which quadrant of the rectangle specified by the
	 // parameters that user data object lies in.
	 // The indicators are defined in the enumeration Direction, and are used
	 // as follows, relative to the center of the rectangle:
	 //
	 // NE: user data object lies in NE quadrant, including non-negative
	 // x-axis, but not the positive y-axis
	 // NW: user data object lies in the NW quadrant, including the
	 // positive y-axis, but not the negative x-axis
	 // SW: user data object lies in the SW quadrant, including the
	 // negative x-axis, but not the negative y-axis
	 // SE: user data object lies in the SE quadrant, including the
	 // negative y-axis, but not the positive x-axis
	 // NOQUADRANT: user data object lies outside the specified rectangle
	 //

	public Direction inQuadrant(double xLo, double xHi, double yLo, double yHi) {
		double yAxisLoc = (xLo + xHi) / 2.0;
		double xAxisLoc = (yLo + yHi) / 2.0;
		double x = (double) this.xcoord;
		double y = (double) this.ycoord;
		if (!inBox(xLo, xHi, yLo, yHi)) {
			return Direction.NOQUADRANT;
		} else if (x > yAxisLoc && y >= xAxisLoc) {
			return Direction.NE;
		} else if (x <= yAxisLoc && y > xAxisLoc) {
			return Direction.NW;
		} else if (x < yAxisLoc && y <= xAxisLoc) {
			return Direction.SW;
		} else if (x >= yAxisLoc && y < xAxisLoc) {
			return Direction.SE;
		}

		return Direction.NOQUADRANT;
	}

	
	// Returns true iff the user data object lies within or on the boundaries
	// of the rectangle specified by the parameters
	public boolean inBox(double xLo, double xHi, double yLo, double yHi) {
		// xLo <= this.xcoord <= this.xHi
		// yLo <= this.ycoord <= this.yHi
		double yLo2 = yLo;
		double yHi2 = yHi;
		double xLo2 = xLo;
		double xHi2 = xHi;
		if (yLo > yHi) { // negative numbers probably
			yLo2 = yHi;
			yHi2 = yLo;
		}
		if (xLo > xHi) {
			xLo2 = xHi;
			xHi2 = xLo;
		}
		return (this.getX() >= xLo2 && this.getX() <= xHi2)
				&& (this.getY() >= yLo2 && this.getY() <= yHi2);
	}

	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (xcoord != other.xcoord)
			return false;
		if (ycoord != other.ycoord)
			return false;
		return true;
	}

}
