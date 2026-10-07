package icecream;
import java.util.Stack;

//-------------------------------------------------------------------------
/**
* The IceCreamCone class is an implementation of a ice cream cone using a stack.
* It implements all methods in the IceCreamConeADT class plus additional ones.
* 
* @author G.J. Hu
* @version 2025.07.25
*/

public class IceCreamCone implements IceCreamConeADT {
    private Stack<String> flavors;
    private int numScoops;
    
    /**
     * Creates an IceCreamCone with no scoops.
     */
    public IceCreamCone() {
        flavors = new Stack<>();
        numScoops = 0;
    }
    
    /**
     * Eat the top scoop of ice cream.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return The flavor of the scoop eaten.
     */
    public String eatScoop() {
        if (flavors.empty()) {
            throw new IllegalStateException("Can't pop from empty stack");
        }
        numScoops--;
        return flavors.pop();
    }
    
    /**
     * Add a scoop of ice cream to the top of the ice cream cone.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor of ice cream to be added.
     */
    public void addScoop(String flavor) {
        if (flavor == null) {
            throw new IllegalArgumentException("Null flavors are invalid");
        }
        flavors.push(flavor);
        numScoops++;
    }
    
    /**
     * The number of scoops on the cone.
     * 
     * @return Returns the number of scoops on the cone.
     */
    public int numScoops() {
        return numScoops;
    }
    
    /**
     * Check if your cone already contains a specific flavor of ice cream.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor to be checked for.
     * @return Returns true if the cone already contains the desired flavor.
     */
    public boolean contains(String flavor) {
        if (flavor == null) {
            throw new IllegalArgumentException("Null check for search");
        }
        for (int i = 0; i < flavors.size(); i++) {
            if (flavors.get(i) == flavor) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if any scoops of ice cream are left.
     * 
     * @return Returns true if there are no ice cream scoops left in the cone.
     */
    public boolean emptyCone() {
        return flavors.empty();
    }
    
    /**
     * The flavor of the ice cream at the top of the cone.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return Returns the flavor of the top of the cone.
     */
    public String currentScoop() {
        if (flavors.empty()) {
            throw new IllegalStateException("Can’t peek from empty stack");
        }
        return flavors.peek();
    }
    
    /**
     * Returns a string representation of the ice cream cone. Format: The
     * flavors are surrounded by brackets: [] The flavors are separated by
     * commas. Example: [Vanilla, Chocolate, Rocky Road] Orientation: Flavors
     * are appended to the right when pushed onto the stack. Flavors are removed
     * from the right when popped off the stack.
     * 
     * @return The string of the ice cream flavors.
     */
    @Override
    public String toString() {
        String endResult = "";
        for (int i = 0; i < flavors.size(); i++) {
            String addOn = flavors.get(i);
            endResult += addOn;
            if (i != flavors.size() - 1) {
                endResult += ", ";
            }
        }
        
        return "[" + endResult + "]";
        
    }
    
    /**
     * For two ice cream cones to be equal they need to contain the same items
     * in the same order.
     *
     * @param o
     *            Other IceCeramCone to be compared with for equality.
     * @return Returns true if the two IceCreamCones have the same items in 
     * the same order.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        IceCreamCone other = (IceCreamCone) o;
        if (this.numScoops() != other.numScoops()) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < this.numScoops(); i++) {
            if (flavors.get(i).equals(other.flavors.get(i))) {
                count++;
            }
        }
    
        return count == this.numScoops();
    }
}
