/**
 * 
 */
package icecream;

import java.util.Stack;

/**
 * @author Vishesh
 * @version 02/21/2020
 *
 */
public class IceCreamCone implements IceCreamConeADT {

    private Stack<String> flavors;
    private int numScoops;
    /**
     * declares the constructor for the class.
     */
    public IceCreamCone() {
        flavors = new Stack<String>();
        numScoops = 0;
    }


    @Override
    public String eatScoop() {

        numScoops--;
        return flavors.pop();
    }


    @Override
    public void addScoop(String flavor) {

        flavors.push(flavor);
        numScoops++;
    }


    @Override
    public int numScoops() {

        return numScoops;
    }


    @Override
    public boolean contains(String flavor) {

        return flavors.search(flavor) > -1;
    }


    @Override
    public boolean emptyCone() {

        return flavors.empty();
    }


    @Override
    public String currentScoop() {

        return flavors.peek();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() == this.getClass()) {
            IceCreamCone other = (IceCreamCone)obj;

            return flavors.equals(other.flavors);
        }

        return false;
    }
    
    /**
     * gets the items in the stack in the form of strings.
     * 
     * @return gives the items in terms of string.
     */
    public String toString() {
        return flavors.toString();
    }

}
