/**
 * 
 */
package icecream;

/**
 * @author Vishesh
 *
 */
public class SkipNode {
    
    public SkipNode[] next;
    private String name;
    
    public SkipNode(String name, int level)
    {
         this.name = name;
        
         next = new SkipNode[level + 1];
         for (int i = 0; i < level; i++)
         {
            next[i] = null;
         }    
    }
    
    public String getName()
    {
        return name;
    }
}
