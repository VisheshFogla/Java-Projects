// On my honor:
//
// - I have not discussed the Java language code in my program with
// anyone other than my instructor or the teaching assistants
// assigned to this course.
//
// - I have not used Java language code obtained from another student,
// or any other unauthorized source, including the Internet, either
// modified or unmodified.
//
// - If any Java language code or documentation used in my program
// was obtained from another source, such as a text book or course
// notes, that has been clearly noted with a proper citation in
// the comments of my program.
//
// - I have not designed this program in such a way as to defeat or
// interfere with the normal operation of the grading code.
//
// Vishesh Fogla
// visheshfogla

package cs3114.J2.DS;
import java.util.ArrayList;

public class prQuadTree<T extends Compare2D<? super T>> {

	abstract class prQuadNode {
	}

	class prQuadLeaf extends prQuadNode {
		ArrayList<T> Elements;

		/**
		 * A default constructor for prQuadLeaf is defined that initializes the
		 * ArrayList Elements that will store the single data value in the leaf.
		 */
		public prQuadLeaf() {
			this.Elements = new ArrayList<T>();
		}

		/**
		 * A second constructor for prQuadLeaf has been defined here that takes an
		 * element of type T as parameter and then adds the element to the list of
		 * ArrayList Elements. This constructor serves the purpose directly adding the
		 * element to the ArrayList.
		 * 
		 * @param member to be added to the list.
		 */
		public prQuadLeaf(T member) {
			this.Elements = new ArrayList<T>();
			this.Elements.add(member);
		}
	}

	class prQuadInternal extends prQuadNode {
		prQuadNode NW, NE, SE, SW;

		/**
		 * Creating a default constructor for the Internal node class.
		 */
		public prQuadInternal() {
			// Just a defualt constructor for the class.
		}
	}

	prQuadNode root;
	long xMin, xMax, yMin, yMax;

	// Initialize quadtree to empty state, representing the specified region.
	/**
	 * 
	 * @param xMin the lower boundary of the x axis
	 * @param xMax the upper boundary of the x axis
	 * @param yMin the lower boundary of the y axis
	 * @param yMax the upper boundary of the y axis.
	 */
	public prQuadTree(long xMin, long xMax, long yMin, long yMax) {
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMax = yMax;
		this.yMin = yMin;
	}

	// Pre: elem != null
	// Post: If elem lies within the tree's region, and elem is not already
	// present in the tree, elem has been inserted into the tree.
	// Return true iff elem is inserted into the tree.
	/**
	 * 
	 * Inserts an element into the tree by adding an internal or a leaf node.
	 * 
	 * @param elem to be added
	 * @return boolean true if the element was added and false if it wasn't
	 */
	public boolean insert(T elem) {

		// checking if the coordinate in the tree or not
		if (this.find(elem) != null) {
			return false;

		}

		// checking if the coordinate lies within the space given or not
		if (!elem.inBox(this.xMin, this.xMax, this.yMin, this.yMax)) {
			return false;
		}

		// inserting the element with the help of a helper function and through
		// recursion
		this.root = insertHelper(this.root, elem, this.xMin, this.xMax, this.yMin, this.yMax);

		return true;
	}

	/**
	 * 
	 * A helper method that inserts an element into the tree by taking parameters
	 * that include the rootNode and the element as well as the boundaries. This
	 * makes navigation to the required cell easier and quicker.
	 * 
	 * @param rootNode the rootnod of the tree given
	 * @param elem     element that is to be added
	 * @param minX     the lower boundary of the x axis
	 * @param maxX     the upper boundary of the x axis
	 * @param minY     the lower boundary of the y axis
	 * @param maxY     the upper boundary of the y axis.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private prQuadNode insertHelper(prQuadNode rootNode, T elem, double minX, double maxX, double minY, double maxY) {

		// chedcking if the root node is null
		// making the root node a leaf node if it is null
		if (rootNode == null) {
			return new prQuadLeaf(elem);
		}
		// checks if the node is an internal node and adds it
		if (rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadInternal")) {

			// calls a function to add an internal Node.
			return addInternalNode(rootNode, elem, minX, maxX, minY, maxY);

		}

		// checks if we need to add a leaf Node
		if (rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadLeaf")) {
			
			prQuadInternal subNode = new prQuadInternal();
			
			prQuadLeaf newLeaf = (prQuadLeaf) rootNode;

			// Determining the quadrant where the leaf would go.
			subNode = (prQuadInternal) insertHelper(subNode, newLeaf.Elements.get(0), minX, maxX, minY, maxY);
			
			// Determining the quadrant where the leaf would go.
			subNode = (prQuadInternal) insertHelper(subNode, elem, minX, maxX, minY, maxY);
			
			return subNode;
		}

		return null;

	}

	/**
	 * 
	 * A helper method that adds an internal node and is called by the insertHelper
	 * method.
	 * 
	 * @param rootNode the rootnod of the tree given
	 * @param elem     element that is to be added
	 * @param minX     the lower boundary of the x axis
	 * @param maxX     the upper boundary of the x axis
	 * @param minY     the lower boundary of the y axis
	 * @param maxY     the upper boundary of the y axis.
	 * @return the internal node that is added.
	 */
	@SuppressWarnings("unchecked")
	private prQuadNode addInternalNode(prQuadNode rootNode, T elem, double minX, double maxX, double minY,
			double maxY) {

		prQuadInternal newNode = (prQuadInternal) rootNode;

		// Find the direction the node should be in, and then get those bounds
		Direction getQuad = elem.inQuadrant(minX, maxX, minY, maxY);
		
		//get boundary values for the region
		double[] boundaryValues = findRegion(getQuad, minX, maxX, minY, maxY);
		
		//Using switch case for recursion.
		switch (getQuad) {
		case NE:
			newNode.NE = insertHelper(newNode.NE, elem, boundaryValues[0], boundaryValues[1], boundaryValues[2],
					boundaryValues[3]);
			break;
		case NW:
			newNode.NW = insertHelper(newNode.NW, elem, boundaryValues[0], boundaryValues[1], boundaryValues[2],
					boundaryValues[3]);
			break;
		case SE:
			newNode.SE = insertHelper(newNode.SE, elem, boundaryValues[0], boundaryValues[1], boundaryValues[2],
					boundaryValues[3]);
			break;
		case SW:
			newNode.SW = insertHelper(newNode.SW, elem, boundaryValues[0], boundaryValues[1], boundaryValues[2],
					boundaryValues[3]);
			break;
		default:
			break;
		}
		
		//returns the newNode
		return newNode;

	}

	/**
	 * 
	 * A helper method to determine the boundaries of the region in which the
	 * element might lie.
	 * 
	 * @param xMin the lower boundary of the x axis
	 * @param xMax the upper boundary of the x axis
	 * @param yMin the lower boundary of the y axis
	 * @param yMax the upper boundary of the y axis.
	 * @return a double array indicating the region in four coordinates.
	 */
	private double[] findRegion(Direction direction, double xMin, double xMax, double yMin, double yMax) {
		
		double[] quadArea = null;
		
		//Determining the length of X axis
		double lengthX = (yMin + yMax) / 2.0; 
		
		//Finding the length of Y axis
		double lengthY = (xMin + xMax) / 2.0;

		//Using switch case to know the bounds
		switch (direction) {
		case NE:
			quadArea = new double[] { lengthY, xMax, lengthX, yMax };
			break;
		case NW:
			quadArea = new double[] { xMin, lengthY, lengthX, yMax };
			break;
		case SE:
			quadArea = new double[] { lengthY, xMax, yMin, lengthX };
			break;
		case SW:
			quadArea = new double[] { xMin, lengthY, yMin, lengthX };
			break;
		default:
			break;
		}
		
		
		return quadArea;

	}

	// Pre: elem != null
	// Returns reference to an element x within the tree such that
	// elem.equals(x)is true, provided such a matching element occurs within
	// the tree; returns null otherwise.
	/**
	 * 
	 * @param Elem the element that is to be found.
	 * @return the element that we need to find.
	 */
	public T find(T Elem) {
		return findHelper(Elem, this.root, this.xMin, this.xMax, this.yMin, this.yMax);
	}

	/**
	 * 
	 * The method if a helper method for find that takes in a root node as its parameter.
	 * 
	 * @param Elem
	 * @param rootNode
	 * @param minX the lower boundary of the x axis
	 * @param maxX the upper boundary of the x axis
	 * @param minY the lower boundary of the y axis
	 * @param maxY the upper boundary of the y axis.
	 * @return the element if found otherwise return null.
	 */
	@SuppressWarnings("unchecked")
	private T findHelper(T Elem, prQuadNode rootNode, double minX, double maxX, double minY, double maxY) {
		
		//if root node is null
		if (rootNode == null) {
			return null;
		}
		
		//if the element is in an internal node
		if (rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadInternal")) {// recursively find the
																								// node
			return findInternalNode(Elem, rootNode, minX, maxX, minY, maxY);

		}

		// if the element is in the leaf node
		if (rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadLeaf"))

		{
			prQuadLeaf leafNode = (prQuadLeaf) rootNode;

			if (leafNode.Elements.get(0).equals(Elem)) {
				return leafNode.Elements.get(0);
			}

			return null;
		}

		return null;
	}

	/**
	 * The method finds the element if present in an internal node.
	 * 
	 * @param Elem the element to be found
	 * @param node the root node of tree
	 * @param xLo the lower boundary of the x axis
	 * @param xHi the upper boundary of the x axis
	 * @param yLo the lower boundary of the y axis
	 * @param yHi the upper boundary of the y axis.
	 * @return the element if found in the internal node.
	 */
	@SuppressWarnings("unchecked")
	private T findInternalNode(T Elem, prQuadNode rNode, double xLo, double xHi, double yLo, double yHi) {

		prQuadInternal internalNode = (prQuadInternal) rNode;

		// Get the quadrant to find the element in through recursion.
		Direction getQuad = Elem.inQuadrant(xLo, xHi, yLo, yHi);
		double[] boundValues = findRegion(getQuad, xLo, xHi, yLo, yHi);
		
		//Using switch case and recursion to find element in internal node.
		switch (getQuad) {
		case NE:
			return findHelper(Elem, internalNode.NE, boundValues[0], boundValues[1], boundValues[2], boundValues[3]);
		case NW:
			return findHelper(Elem, internalNode.NW, boundValues[0], boundValues[1], boundValues[2], boundValues[3]);
		case SE:
			return findHelper(Elem, internalNode.SE, boundValues[0], boundValues[1], boundValues[2], boundValues[3]);
		case SW:
			return findHelper(Elem, internalNode.SW, boundValues[0], boundValues[1], boundValues[2], boundValues[3]);
		default:
			return null;
		}

	}

	// Pre: xLo, xHi, yLo and yHi define a rectangular region
	// Returns a collection of (references to) all elements x such that x is
	// in the tree and x lies at coordinates within the defined rectangular
	// region, including the boundary of the region.
	/**
	 * 
	 * A method that Returns a collection of (references to) all elements x such that x is
	 * in the tree and x lies at coordinates within the defined rectangular
	 * region, including the boundary of the region.
	 * 
	 * @param xLo the lower boundary of the x axis
	 * @param xHi the upper boundary of the x axis
	 * @param yLo the lower boundary of the y axis
	 * @param yHi the upper boundary of the y axis.
	 * @return an arrayList 
	 */
	public ArrayList<T> find(long xLo, long xHi, long yLo, long yHi) {

		ArrayList<T> collection = new ArrayList<T>();
		
		findHelperForList(collection, this.root, xLo, xHi, yLo, yHi);
		
		return collection;
	}

	/**
	 * 
	 * @param store to store a collection of elements in the array list
	 * @param rootNode the root node 
	 * @param xLo the lower boundary of the x axis
	 * @param xHi the upper boundary of the x axis
	 * @param yLo the lower boundary of the y axis
	 * @param yHi the upper boundary of the y axis.
	 */
	@SuppressWarnings("unchecked")
	private void findHelperForList(ArrayList<T> store, prQuadNode rootNode, long xLo, long xHi, long yLo, long yHi) {
		if (rootNode == null) {
			return;
		} 
		
		if (rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadInternal")) {

			//Checking if any quadrants intersect.
			checkIntersectingQuads(store, rootNode, xLo, xHi, yLo, yHi);

		}
		
		if(rootNode.getClass().getName().equals("cs3114.J2.DS.prQuadTree$prQuadLeaf")){
			
			prQuadLeaf leafNode = (prQuadLeaf) rootNode;
			
			//Storing the element
			if (leafNode.Elements.get(0).inBox(xLo, xHi, yLo, yHi))
			{
				store.add(leafNode.Elements.get(0));
			}
		}
	}
	
	/**
	 * The method checks if there is any quadrant that overlaps
	 * Also checks that the leaf nodes are in the same area of the quadrant.
	 * 
	 * @param store array to store the collection of elements
	 * @param rNode the root node 
	 * @param xMin the lower boundary of the x axis
	 * @param xMax the upper boundary of the x axis
	 * @param yMin the lower boundary of the y axis
	 * @param yMax the upper boundary of the y axis.
	 */
	@SuppressWarnings("unchecked")
	private void checkIntersectingQuads(ArrayList<T> store, prQuadNode rNode, long xMin, long xMax, long yMin, long yMax) {
		

		prQuadInternal internalNode = (prQuadInternal) rNode;
		double[] limitsNE = findRegion(Direction.NE, xMin, xMax, yMin, yMax);
		double[] limitsSW = findRegion(Direction.SW, xMin, xMax, yMin, yMax);
		double[] limitsNW = findRegion(Direction.NW, xMin, xMax, yMin, yMax);
		double[] limitsSE = findRegion(Direction.SE, xMin, xMax, yMin, yMax);
		if (areaIntersections(limitsNE, xMin, xMax, yMin, yMax)) {
			findHelperForList(store, internalNode.NE, xMin, xMax, yMin, yMax);
		}
		if (areaIntersections(limitsNW, xMin, xMax, yMin, yMax)) {
			findHelperForList(store, internalNode.NW, xMin, xMax, yMin, yMax);
		}
		if (areaIntersections(limitsSE, xMin, xMax, yMin, yMax)) {
			findHelperForList(store, internalNode.SE, xMin, xMax, yMin, yMax);
		}
		if (areaIntersections(limitsSW, xMin, xMax, yMin, yMax)) {
			findHelperForList(store, internalNode.SW, xMin, xMax, yMin, yMax);
		}
		
	}

	
	/**
	 * 
	 * A method to find the area intersections by necessary calculations.
	 * 
	 * @param limits the first region bounds
	 * @param x2Min second region x min
	 * @param x2Max second region x max
	 * @param y2Min second region y min
	 * @param y2Max second region y max
	 * @return
	 */
	private boolean areaIntersections(double[] limits, double x2Min, double x2Max, double y2Min,
			double y2Max) {
		double limit1Width = Math.abs(limits[0]) + Math.abs(limits[1]);
		double limit1Height = Math.abs(limits[2]) + Math.abs(limits[3]);

		double limit2Width = Math.abs(x2Min) + Math.abs(x2Max);
		double limit2Height = Math.abs(y2Min) + Math.abs(y2Max);

		return (limits[0] + limit1Width >= x2Min && limits[2] + limit1Height >= y2Min
				&& limits[0] <= x2Min + limit2Width && limits[2] <= y2Min + limit2Height);
	}

}
