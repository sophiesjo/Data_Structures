
/**
 * PP1: Indexing Substrings
 * 
 * The intention of this class is to break up all the info and find which lines contain specifically the
 * general information, the description, and then the sequence. This class also contains accessor methods
 * that return specific information.
 *
 * @author Sophie Sjogren
 * @version April 19, 2021
 */
public class DNASequence
{
    // instance variables
    private String genInfo;
    private String description;
    private String sequence;

    /**
     * Constructor for objects of class DNASequence
     */
    public DNASequence(String info, String sampleNum, String stringSeq)
    {
        this.genInfo = info;
        this.description = sampleNum;
        this.sequence = stringSeq;
    }
    
    /**
     * Constructor for objects of class DNASequence
     */
    public DNASequence(String stringSeq)
    {
        //Creat a boolean that will keep track if the genInfo is being looked at
        boolean giUndefined = true;     //Originally set to true because first line of the string will be the general info
        int descriptionStart = 0;       //This will help tell when the description info is starting in the string
        
        for (int i = 0; i < stringSeq.length(); i++)
        {
            //The if loop is meant to find when there is a new line in the data
            if(Character.toString(stringSeq.charAt(i)).equals(";"))
            {
                //This will keep track of when the new line is general information and will assign the next two lines to be the description then sequence
                if(giUndefined == true)
                {
                    this.genInfo = stringSeq.substring(0, i);
                    giUndefined = false;    //reset the general info to be false
                    descriptionStart = i + 1;
                }
                else
                {
                    //Separate the description and sequence individually
                    this.description = stringSeq.substring(descriptionStart, i);    //assign the following line to be the description
                    this.sequence = stringSeq.substring(i+1, stringSeq.length());   //because we know the description line, the following line will be the sequence
                }
            }
        }
    }
    
    /** This accessor method gets the general information.
     * 
     * @return  the string with the general information
     **/
    public String getGI() 
    {
        //return the general information
        return this.genInfo;
    }
    
    /** This accessor methods gets the description
     * 
     * @return  the string with the description
     **/
    public String getDescription() 
    {
        //return the description
        return this.description;
    }
    
    /** This accessor method gets the sequence
     * 
     * @return  the string with the sequence 
     **/
    public String getSequence() 
    {
        //return the sequence
        return this.sequence;
    }

    /** Returns a string of key information including the general info, the description, and the sequence 
     * 
     *  @return  a string indicating the general info, description, and sequence
     **/
    public String toString()
    {
        //return the general info, description, and sequence in a string format
        return getGI() + getDescription() + getSequence();
    }
}
