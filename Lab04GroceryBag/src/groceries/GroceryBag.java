package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects
 * that represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 */
public class GroceryBag extends ArrayBasedBag {
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the
     * intersection. If there are multiple occurrences of that
     * element, then the number of occurrences of that element
     * in the intersection will equal the minimum number of occurrences
     * in either set.
     * 
     * Examples:
     * intersection of
     * ({"apple","apple","cereal","chips"},
     * {"chips", "apple","apple","chips","cake"})
     * = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        // Implement this method
        String[] firstBag = this.contents();

        String[] secondBag = bag.contents();

        GroceryBag intersect = new GroceryBag();

        for (int i = 0; i < firstBag.length; i++) {
            for (int j = 0; j < secondBag.length; j++) {
                if ((firstBag[i] != null) && (secondBag[j] != null)
                    && (firstBag[i].equals((secondBag[j])))) {
                    intersect.add(firstBag[i]);
                    firstBag[i] = null;
                    secondBag[j] = null;
                }
            }
        }
        return intersect;
    }


    /**
     * For two bags to be equal they need to contain items
     * with the exact same value (but not the same item, so
     * equality not identity). Order does not matter, but
     * number of occurrences does.
     * 
     * @param givenBag
     *            Other GroceryBag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        if (givenBag == this) {
            return true;
        }

        if (givenBag == null) {
            return false;
        }

        if (this.getClass() == givenBag.getClass()) {
            GroceryBag other = (GroceryBag)givenBag;

            String[] st1 = this.contents();

            if (other.size() == this.size()) {
                for (int i = 0; i < this.size(); i++) {
                    String temp = st1[i];

                    int count = this.occurrence(temp);
                    int count2 = other.occurrence(temp);

                    if (count != count2) {
                        return false;
                    }

                }

                return true;
            }
        }

        return false;
    }

}
