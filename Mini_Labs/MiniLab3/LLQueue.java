import java.util.LinkedList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The LLQueue class creates the linked list that stores the data and has accessor 
 * methods which allow the user to get information from the list and there are also
 * modifier methods which allow the user to remove elements from the front and add 
 * elements to the end. 
 *
 * @author Sophie Sjogren
 * @version 4-26-21
 */
public class LLQueue<T> implements KQueue<T>
{
    //using an arraylist
    //ArrayList<T> queue;

    //using an array 
    //T[] q;
    //int[] s;

    //for linked list
    LinkedList<T> queue;    //contains the elements in the list
    Node<T> first;          //keeps track of the first element in the list
    Node<T> last;           //keeps track of the last element in the list

    //instance variables
    int size;               //will keep track of the size of the array

    /**
     * constructr for objects of class LLQueue
     */
    public LLQueue()
    {
        //initilize arraylist
        //queue = new ArrayList<T>();

        //initiliaze array
        //q = new int[100];

        //initialize a linked list, size, and first and last elements
        queue = new LinkedList<T>();
        size = 0;
        first = null;
        last = null;
    }

    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
    public boolean isEmpty()
    {
        //determine if the size of the queue is equal to zero and return a boolean according to its size
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    public void enqueue(T item)
    {
        //add the item to the queue
        queue.add(item);

        //create a node for the linked list 
        Node<T> currentNode = new Node<T>(item);
        if(isEmpty()) 
        {
            //resets last and first because it is empty
            last = currentNode;
            first = currentNode;
        }
        else 
        {
            //assign the next node in the list to be the new item, this will become the last 
            last.setNext(currentNode);
            last = currentNode;
        }

        //increase the size of the list
        size++;
    }

    /** Removes the element at the "front" of this queue.
     *    @returns the removed element
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T dequeue()
    {
        //Get the first element as a node and assign it to the result
        Node<T> firstElement = first;
        T result = firstElement.getElement();
        if(isEmpty())
        {
            //this will return as null pointer exception because the first element is empty
            return result;
        }
        else
        {
            //assign the next element to be the first and decrease the size, the result will be the original first element
            firstElement = firstElement.getNext();
            first = firstElement;
            size--;
            return result;
        }
        
    }

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T peekFront()
    {
        //return the head of the queue but don't do anything else with the head
        return first.getElement();
    }

    /** 
     *    Returns the size of the linkedlist 
     *    @returns  the size of the list
     **/
    public int size()
    {
        //return the size variable
        return size;
    }

    /** 
     * Returns the string value of the queue and prints each element
     *  @returns    the string of elements in the queue
     *    
     **/
    public String toString()
    {
        //create an arraylist that will store the string values
        ArrayList<String> stringList = new ArrayList<String>();
        
        //use a for loop to get each element in the queue
        for(int i = 0; i < queue.size(); i++)
        {
            //add the individual elements from the queue into the string array
            stringList.add(queue.get(i).toString());    //have to convert it to a string
        }
        
        //return the arraylist as a string value
        return stringList.toString();
    }

}
