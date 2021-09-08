package groceries;

import java.io.*;
import java.util.Scanner;

/**
 * Practice reading and writing to a file.
 * 
 * @author Megan Rigsbee (mrigsbee0
 * @version 2015.03.24
 */
public class FileIO {
    /**
     * 
     * @param filename takes the filename to scan.
     */
    public FileIO(String filename)
    {
        
    }
    
    
    /**
     * Reads groceries from a file and adds them to a GroceryBag object,
     * the writes the groceries back to a file using GroceryBag's
     * toString method.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        
        File file = new File("grocerylist.txt");
            
        GroceryBag bag1 = new GroceryBag();
        
        Scanner input;
        try {
            input = new Scanner(file);
            
            while(input.hasNext())
            {
                bag1.add(input.next());
            }
            
            input.close();
            
            PrintWriter pw = new PrintWriter("output.txt");
            
            pw.print(bag1.toString());
            
            pw.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            
            System.out.println("Scanner error opening the file ");
            System.out.println(e.getMessage());
        }
        
        
        
    }
}
