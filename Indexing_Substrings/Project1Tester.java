
/**
 * PP1: Indexing Substrings
 * 
 * This class contains the main method that creates an indexer object and runs the method that analyzes the data and prints the results
 *
 * @author Sophie Sjogren
 * @version April 19, 2021
 */
public class Project1Tester
{
    public static void main(String[] args)
    {
        Debug.turnOn();
        //Create Indexer object
        Indexer test = new Indexer();
        
        //Call the run and printResults method in the Indexer class
        test.run();
        test.printResults();
        
    }
}
