
/**
 * This class finds a sum of all the integer values in the tree and has an accessor 
 * and modifier method which increases the sum and returns the sum. 
 *
 * @author Sophie Sjogren
 * @version 5 June 2021
 */
public class SumReduction implements NodeVisitor
{
    // instance variables 
    private int sum;        //keeps track of the sum

    /**
     * Constructor for objects of class SumReduction
     */
    public SumReduction()
    {
        
    }

    /**
     * This visit method gets the int value of the data and adds it to the sum.
     *
     * @param  data this mut be an Integer that is passed
     */
    public void visit(Object data)
    {
        //if the data is not null then add to the sum
        if ( data != null )
        {
            //get the int value of the data and increase sum according to that int
            Integer newSet = new Integer((Integer)data);
            sum += newSet.intValue();
        }
    }
    
    /**
     * This accessor method gets the sum of the data
     *
     * @return    the sum of the visit method
     */
    public int getSum()
    {
        //return the total sum found 
        return sum;
    }
}
