import java.util.ArrayList;
/**
 * PP1: Indexing Substrings
 * 
 * This class keeps track of the substring and its associated location. This contains accessor methods
 * that allow the user to get the location and substring along with a modifier method that allows 
 * the user to add locations for a specific substring.
 *
 * @author Sophie Sjogren
 * @version April 19, 2021
 */
public class SubstringLocs
{
    // instance variables
    private String substring;                       //the substring that is being specified
    private ArrayList<Location> stringLocations;    //an array of locations of the substring
     

    /**
     * Constructor for objects of class SubstringLocs
     * 
     * @param stringSequence    the substring associated with the location
     * @param locs              an arraylist of locations of the substring
     */
    public SubstringLocs(String stringSequence, ArrayList<Location> locs)
    {
        //initialize the instance variables with the given parameters
        this.substring = stringSequence;
        this.stringLocations = locs;
    }

    /**
     * This modifier method allows the user to add locations for a substring
     *
     * @param  newLocation      this is the location being added to the list
     */
    public void addLocation(Location newLocation)
    {
        //add the new location to the array list
        stringLocations.add(newLocation);
    }
    
    /**
     * This accesor method gets the substring
     *
     * @return    the String that contains the substring
     */
    public String getSubstring()
    {
        //return the specific substring
        return this.substring;
    }
    
    /**
     * This accesor method gets the list of locations for a substring
     *
     * @return    the arraylist that contains locations
     */
    public ArrayList<Location> getLocations()
    {
        //return the list of locations
        return stringLocations;
    }
    
    /**
     * This method turns the substring and location into a printable format
     *
     * @return    the String that contains both the substring and location
     */
    public String toString()
    {
        //return the substring and location in a string format
        return getSubstring() + " (" + getLocations() + ") ";
    }
    
}
