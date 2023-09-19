
/**
 * PP1: Indexing Substrings
 * 
 * This class organizes and keeps track of the locations by indentifying the string and where that string starts.
 *
 * @author Sophie Sjogren
 * @version April 19, 2021
 */
public class Location
{
    // instance variables
    private int seqNum;
    private int startingPoint;

    /**
     * Constructor for objects of class Location
     */
    public Location(int seq, int start)
    {
        // initialise instance variables
        this.seqNum = seq;
        this.startingPoint = start;
    }
    

    /**
     * This method gets the order of the sequence, if it is the first, second, third, so on.
     *
     * @return    the int that describes which sequence it is
     */
    public int getSequenceNum()
    {
        //return the sequence number
        return seqNum;
    }
    
    /**
     * This accessor method gets where the substring is starting in the sequence
     *
     * @return    the int that describes where the substring starts within the sequence
     */
    public int getStartingPoint()
    {
        //Return the starting point of the substring
        return startingPoint;
    }
    
    /**
     * This method organizes the sequence number and starting point so it is accesible to the user
     *
     * @return    the string that contains the key information
     */
    public String toString()
    {
        //Use the accesor methods to get the sequence number and starting point
        return " (" + getSequenceNum() + " , " + getStartingPoint() + ") ";
    }
}
