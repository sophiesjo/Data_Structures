import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
/**
 * This class creates an arraylist which has elements added to it in an ordered
 * way and uses binarysearch to find values in the list. The arraylist is a generic
 * type and has modifier and accessor methods for the arraylist.
 *
 * @author Sophie Sjogren, worked with Tabitha
 * @version 5-7-21
 */
public class OrderList<T extends Comparable<T>>

{
    // instance variables
    ArrayList<T> orderedList;   //arraylist containing the elements

    /**
     * Constructor for objects of class OrderList
     */
    public OrderList()
    {
        //initialize the arraylist
        orderedList = new ArrayList<T>();
    }

    /**
     * This method uses a binary search method to find the specified value and
     * returns -1 if it is not found.
     *
     * @param  val  the element being added to the list
     * @return    the position of the value, or -1 if not found
     */
    private int binarySearch(T val)
    {
        //set the min and max values
        int min = 0;
        int max = orderedList.size()-1;
        
        //sort through the min and max values to get the position
        while(min <= max)
        {
            //set mid value to be average of max and min
            int mid = min + (max-min)/2;
            //if the mid is equal to the value wanted then return position
            if(get(mid).compareTo(val) == 0)
            {
                return mid;
            }
            //if not equal, then find if larger or smaller than mid and change the min and max accordingly
            else if(get(mid).compareTo(val) < 0)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }

        }

        //return -1 if above mid was not returned
        return -1;
    }

    /**
     * This method adds a given element to its corresponding position in the
     * list which will put the arraylist in order.
     *
     * @param  element  the element being added to the list
     */
    public void add(T element)
    {
        //if the list is empty then add the element to the front
        if(size() == 0)
        {
            orderedList.add(0,element);
        }
        //if it is not empty then sort through each element in the list starting from the smallest and see where it is less than and add it to its corresponding position
        else
        {
            for(int i = 0; i < size(); i++)
            {
                //check if the given element is less then the next element
                if (orderedList.get(i).compareTo(element) >= 0)
                {
                    //add the element to the list
                    orderedList.add(i, element);
                    return; //end method
                }
            }
            //add the element to the end of the list if it was not already added
            orderedList.add(element);
        }
    }

    /**
     * This method gets an element at a specified index and throws an exception 
     * if the list is empty.
     *
     * @param  index  the position of the element being found
     * @return    the element at the index
     */
    public T get(int index) throws IndexOutOfBoundsException
    {
        //check if empty and throw exception if it is
        if(isEmpty())
        {
            throw new IndexOutOfBoundsException();
        }
        //return the element at the index
        return orderedList.get(index);
    }

    /**
     * This method removes an element from a specified index and returns the 
     * value of that element.
     *
     * @param  index  the index that the element will be removed at
     * @return    the removed element at the index 
     */
    public T remove(int index)
    {
        //return the removed element in the list
        return orderedList.remove(index);
    }

    /**
     * This method checks to make sure the given element is in the list and then returns 
     * false if it is not and returns true and removes the element if it is in the 
     * list.
     *
     * @param  element  the val to be removed in the list
     * @return    true if the element is in the list and false if not
     */
    public boolean removeIfExists(T element)
    {
        //check if element is in the list
        if( find(element) == -1)
        {
            //return false indicating not in list
            return false;
        }
        else
        {
            //get and remove element
            int index = find(element);
            remove(index);
            //return true indicating in the list 
            return true;
        }
    }

    /**
     * This method calls on the binary search to check if the list contains the
     * element and returns a boolean according to the result.
     *
     * @param  element  the value to search for in the list
     * @return    true if element is in list and false if not
     */
    public boolean contains(T element)
    {
        //call binarySearch(element) to see if element is there
        if(binarySearch(element) == -1)
        {
            //return false indicating element is not there
            return false;
        }

        else 
        {
            //return true indicating element is there
            return true;
        }

    }

    /**
     * This method uses binary search to check if the element is in the list then 
     * returns the index of that element or -1 if it is not in the list.
     *
     * @param  element  the element that will be searched for in the list
     * @return    the index of the element or -1 if not in list
     */
    public int find(T element)
    {
        //look if element exists, return -1 if not
        if(binarySearch(element) == -1)
        {
            //return -1 indicating not in the list
            return -1;
        }
        else 
        {
            //return the index of the element
            return binarySearch(element);
        }
    }

    /**
     * This method checks the size of the list and returns true if the list is
     * empty and returns false if it is not.
     *
     * @return    true if the list is empty and false if not
     */
    public boolean isEmpty()
    {
        //check the size of the list
        if(size() == 0)
        {
            //return true indicating the list is empty
            return true;
        }
        else
        {
            //return false indicating the list is not empty
            return false;
        }
    }

    /**
     * This method gets and returns the size of the list.
     *
     * @return    the size of the list
     */
    public int size()
    {
        //get and return the size of the list
        return orderedList.size();
    }

    /**
     * This method gets each element in the arraylist and prints it as a string
     *
     * @return    the string containing the current state of the list
     */
    public String toString()
    {
        //make an arraylist to store the string version of each element
        ArrayList<String> stringList = new ArrayList<String>();
        //sort through each element and add it to the new string arraylist
        for(int i = 0; i < size(); i++)
        {
            stringList.add(orderedList.get(i).toString());
        }
        //return the arraylist as a string
        return stringList.toString();
    }
}
