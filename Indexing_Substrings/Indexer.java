import java.util.ArrayList;
/**
 * PP1: Indexing Substrings
 * 
 * This class gets a file and string length from the user and gets data from the DNADataReader class.
 * The run method for this class sorts through the data and using the DNASequence class gets only the 
 * sequence line which is used to count the number of times substrings appear in the sequences. The class
 * then prints out the results.
 *
 * @author Sophie Sjogren
 * @version April 19, 2021
 */
public class Indexer
{
    // instance variables
    private String fileName;
    private int stringLength;
    private DNADataReader dataReader;
    private ArrayList<DNASequence> dnaSequences;
    private ArrayList<SubstringLocs> stringAndLocs;

    /**
     * Constructor for objects of class Indexer
     */
    public Indexer()
    {
        //Ask the user for a file name and string length
        this.fileName = ValidatedInputReader.getString("Enter the file name", "DNAData.txt");
        this.stringLength = ValidatedInputReader.getInteger("Enter the length of substrings", 4, "Enter length of substrings that will be used");
        
        //create a DNADataReader object that will read in data from the file inputted by the user
        this.dataReader = new DNADataReader(fileName);
        dnaSequences = dataReader.readData();
        stringAndLocs = null;
    }

    /**
     * This method uses the data from the file and breaks it up into substrings which are compared to substrings
     * at other locations to create a list of specific substrings and all locations associated with it.
     *
     */
    public void run()
    {
        //New array list for keeping track of the data that is only the sequence
        ArrayList<String> seqData = new ArrayList<String>();
        
        //Add data from dnaSequences to the newly created array
        for (DNASequence newString : dnaSequences)
        {
            seqData.add(newString.getSequence());
        }
        
        //Create another new array which will keep track of 
        ArrayList<SubstringLocs> stringLocs = new ArrayList<SubstringLocs>();
        int counter = 0;        //this will keep track of increasing location
        
        //use a for loop to sort through the arraylist containing the sequences
        for (String newString : seqData)
        {
            
            for (int i = 0; i < newString.length() - stringLength + 1; i++)
            {
                //Create an array list that will be passed to the SubstringLocs class
                ArrayList<Location> newLoc = new ArrayList<Location>();
                newLoc.add(new Location(counter, i));
                
                //Create a SubstringLocs object that will keep track of the substring and it's associated location
                SubstringLocs newStringLoc = new SubstringLocs(newString.substring(i, i+ stringLength), newLoc);
                boolean check = false;
                for (SubstringLocs loc : stringLocs)
                {
                    //Check the equilivilance of the substring and add to the location list if true
                    if (newStringLoc.getSubstring().equals(loc.getSubstring()))
                    {
                        loc.addLocation(new Location(counter, i));
                        check = true;
                    }
                }
                if (check == false)
                {
                    stringLocs.add(newStringLoc);
                }
            }
            counter++;
        }
        stringAndLocs = stringLocs;
    }
    
    /**
     * This method uses the instance variables and results from above to print the locations for the user
     *
     */
    public void printResults()
    {
        //Create variable that will be used to print
        String print;
        
        //Sort through the string and locations and print the substring along with its associated locations
        for(SubstringLocs element : stringAndLocs)
        {
            print = element.getSubstring() + ":";
            for (Location loc : element.getLocations())
            {
                print = print + " " + loc;
            }
            System.out.println(print);
        }
    }
    
}
