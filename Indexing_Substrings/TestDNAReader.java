import java.util.ArrayList;

/**
 *  PP1: Indexing Substrings
 *
 *  This class has the main method used to test the DNADataReader class and the results of getting 
 *  data from a file.
 *
 *
 *  @author Sophie Sjogren
 * @version April 19, 2021
 */
public class TestDNAReader
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        Debug.turnOn();
        Debug.println("Program start!");
        
        //use ValidatedInputReader to get file name from the user
        String fileName = ValidatedInputReader.getString("Enter file name", "TestData.txt");
        System.out.println(fileName);       //print the file name
        
        //Constructs the dataReader object 
        DNADataReader dataReader = new DNADataReader(fileName);
        ArrayList<DNADataReader> data = new ArrayList<DNADataReader>();
        System.out.println("\nData from DNADataReader: \n");
        data = dataReader.readData();
        
        //Print out the data from the file
        System.out.println("Data from DNASequence: \n");
        for(int i = 0; i < data.size(); i++)
        {
            System.out.println(data.get(i));
            System.out.println(" ");
        }
        
        //Test the location and substringLocs classes
        System.out.println(new Location(0,4));
        //System.out.println(new SubstringLocs("acgt", null));
    }       //end main
}   //end class
