/**
 * 
 */
package icecream;

/**
 * @author Vishesh
 *
 */
public class Rectangle {

    public String name;
    public int x, y, w, h;
    
    public Rectangle(String name, int x, int y, int w, int h)
    {
        this.name = name; 
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getW()
    {
        return w;
    }
    
    public int getH()
    {
        return h;
    }
    
}
