/**
 * 
 */
package arraystack;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author Vishesh
 * @version 02/28/2020.
 * 
 *
 */
public class ArrayBasedStackTest extends TestCase {

    private ArrayBasedStack<String> stack1;
    private ArrayBasedStack<String> stack2;
    private ArrayBasedStack<String> stack3;
    private ArrayBasedStack<String> stack4;
    private ArrayBasedStack<String> stack7;

    /**
     * initializes the stacks to be used by test methods.
     */
    public void setUp() {
        stack1 = new ArrayBasedStack<>();
        stack2 = new ArrayBasedStack<>();
        stack3 = new ArrayBasedStack<>();
        stack4 = new ArrayBasedStack<>(1);
        stack4.push("vanilla");
        stack1.push("chocolate");
        stack7 = null;
    }


    /**
     * tests if the stack is empty.
     */
    public void testIsEmpty() {
        assertTrue(stack2.isEmpty());
    }


    /**
     * tests if peek method returns the right element.
     */
    public void testPeek() {
        stack2.push("vanilla");
        stack2.push("strawberry");

        assertEquals("strawberry", stack2.peek());

        Exception thrown = null;

        try {
            stack3.peek();
        }
        catch (EmptyStackException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * tests if the pop method returns the right element.
     */
    public void testPop() {
        stack2.push("vanilla");
        stack2.push("strawberry");

        assertEquals("strawberry", stack2.pop());

        Exception thrown = null;

        try {
            stack3.pop();
        }
        catch (EmptyStackException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException); 
    }


    /**
     * tests if the push method.
     */
    public void testPush() {
        stack4.push("strawberry");

        assertEquals("strawberry", stack4.peek());
    }


    /**
     * checks the contains method.
     */
    public void testContains() {
        assertTrue(stack4.contains("vanilla"));
        assertFalse(stack4.contains("strawberry"));
    }


    /**
     * checks the size method.
     */
    public void testSize() {
        assertEquals(1, stack4.size());
    }


    /**
     * checks the clear method.
     */
    public void testClear() {
        stack4.clear();

        assertTrue(stack4.isEmpty());
        assertEquals(0, stack4.size());
    }


    /**
     * checks the toArray method
     */
    public void testToArray() {
        Object[] element = stack4.toArray();

        assertTrue(element[0].equals("vanilla"));
    }


    /**
     * checks the toString method.
     */
    public void testToString() {
        stack4.push("strawberry");
        String element = stack4.toString();
        String ele = stack3.toString();

        assertEquals("[vanilla, strawberry]", element);
        assertEquals("[]", ele);
    }


    /**
     * checks the Equals method.
     */
    public void testEquals() {
        ArrayBasedStack<String> stack5 = new ArrayBasedStack<>(1);
        stack5.push("vanilla");

        ArrayBasedStack<String> stack6 = new ArrayBasedStack<>(1);
        stack6.push("vanilla");
        stack6.push("strawberry");

        String element = "chocolate";

        assertTrue(stack4.equals(stack4));  
        assertTrue(stack4.equals(stack5));
        assertFalse(stack4.equals(stack1)); 
        assertFalse(stack4.equals(element));
        assertFalse(stack4.equals(stack6));
        assertFalse(stack4.equals(stack7));
                
 
    } 
    
    
    public void testDebuggerViews()

    {

                //Put a breakpoint on the line below

                ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();

                 

                //Put a breakpoint on the line below. Use Step Over to see each push.

                testStack.push("blizzard");

                testStack.push("barrage");

                testStack.push("deadeye");

                testStack.push("resurrect");

                 

                assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye, resurrect]"));

                 

                //Put a breakpoint on the line below. Hit Step Over once to watch the pop.

                testStack.pop();

                 

                assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));

                 

                Object[] toArrayResult = testStack.toArray();

                //Drop a breakpoint on the line below.

                //Use the debugger mode to compare toArrayResult to testStack.

                assertTrue(toArrayResult[0].toString().equals("blizzard"));

                assertEquals(toArrayResult.length, 3);

                 

                //The following test fails because the stack still has entries in it. However,

                //"expected <true> but was: <false>" is not very helpful.

                //Drop a breakpoint on the line below to see what the toString SHOULD look like.

                assertTrue(testStack.toString().equals("[]"));

    }

}
