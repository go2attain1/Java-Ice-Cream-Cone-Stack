package icecream;

import java.util.ArrayList;

/**
 * This class tests the IceCreamCone class for correct output.
 * It verifies that the methods in the class do what they are expected to do.
 *
 * @author G.J. Hu
 * @version 2025.07.25
 */

public class IceCreamConeTest extends student.TestCase {
    
    private IceCreamCone cone1;
    private IceCreamCone cone2;
    private static final String STRAWBERRY = "strawberry";
    
    /**
     * Set up for all test methods. Runs before every test.
     */  
    public void setUp() {
        cone1 = new IceCreamCone();
        cone1.addScoop("chocolate");
        cone1.addScoop("vanilla");
        cone2 = new IceCreamCone();        
    }
    
    /**
     * Tests that the eatScoop() method returns the expected output
     */   
    public void testEatScoop() {
        IceCreamCone cone = new IceCreamCone();

        /* below code does not compile under the school's grading environment
        Exception thrown = assertThrows(IllegalStateException.class, () -> {
            cone.eatScoop();
        });
        assertEquals("Cannot eat from an empty cone.", thrown.getMessage());

        */
        Exception thrown = null;
        String scoop = null;
        try {
            scoop = cone.eatScoop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        thrown = null;
        String vanilla = "vanilla";
        cone.addScoop(vanilla);
        try {
            scoop = cone.eatScoop();
        }
        catch (Exception exception) {
            thrown = exception;
        } 

        assertNull(thrown);
        assertEquals(vanilla, scoop);
    }
    
    /**
     * Tests that the addScoop() method returns the expected output
     */   
    public void testAddScoop() {
        IceCreamCone cone = new IceCreamCone();
        String nl = null;
        Exception thrown = null;
        try {
            cone.addScoop(nl);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
       
        int num = cone.numScoops();
        cone.addScoop(STRAWBERRY);
        assertEquals(STRAWBERRY, cone.currentScoop());
        assertEquals(num + 1, cone.numScoops());
        
    }
    
    /**
     * Tests that the numScoops() method returns the expected output
     */   
    public void testNumScoops() {
        IceCreamCone cone3 = new IceCreamCone();
        assertEquals(0, cone3.numScoops());
        cone3.addScoop("watermelon");
        assertEquals(1, cone3.numScoops());
    }
    
    /**
     * Tests that the contains() method returns the expected output
     */   
    public void testContains() {
        String nl = null;
        Exception thrown = null;
        try {
            cone1.contains(nl);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(true, cone1.contains("vanilla"));
        
        assertEquals(false, cone1.contains("watermelon"));
    }
    
    /**
     * Tests that the emptyCone() method returns the expected output
     */   
    public void testEmptyCone() {
        assertTrue(cone2.emptyCone());       
        assertFalse(cone1.emptyCone());
    }
    
    /**
     * Tests that the currentScoop() method returns the expected output
     */   
    public void testCurrentScoop() {
        IceCreamCone cone = new IceCreamCone();
        String scoop = null;
        Exception thrown = null;
        try {
            scoop = cone.currentScoop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);

        cone.addScoop(STRAWBERRY);
        scoop = cone.currentScoop();
        assertTrue(scoop.equals(STRAWBERRY));
    }
    
    /**
     * Tests that the equals() method returns the expected output
     */   
    public void testEquals() {
        Object o = null;
        assertFalse(cone1.equals(o));
        
        o = cone1;
        assertTrue(cone1.equals(o));
        
        o = new ArrayList<String>();
        assertFalse(cone1.equals(o));
        
        IceCreamCone cone = new IceCreamCone();
        cone.addScoop("chocolate");
        cone.addScoop("vanilla");
        assertTrue(cone1.equals(cone));
        
        assertFalse(cone1.equals(cone2));
        
        IceCreamCone cone6 = new IceCreamCone();
        cone6.addScoop("chocolate");
        cone6.addScoop("caramel");
        assertFalse(cone1.equals(cone6));

        IceCreamCone cone7 = new IceCreamCone();
        cone7.addScoop("vanilla");
        cone7.addScoop("chocolate");
        assertFalse(cone1.equals(cone7));
    }
    
    /**
     * Tests that the toString() method returns the expected output
     */  
    public void testToString() {
        IceCreamCone cone5 = new IceCreamCone();
        cone5.addScoop("almond");
        cone5.addScoop("cookie");
        assertEquals("[almond, cookie]", cone5.toString());
    }
}
