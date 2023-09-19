import java.util.LinkedList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class allows a specific node to be created and ascessed within the linked list.
 * I'm not sure if this class is necessary, but it helped me initialize variables
 * and edit them more easily. May have complicated things more tho
 * 
 *
 * @author Sophie Sjogren
 * @version 4-26-21
 * 
 */
public class Node<T>
{
    //Instance variables
    private Node<T> nextElement;
    private T element; 

    /**
     * Constructor for a node in the linkedlist
     * @param newElement, element in the list
     */
    public Node(T newElement) 
    {
        //set the values for the variables
        nextElement = null;
        this.element = newElement;
    }

    /**
     * This method gets the element in the linkedlist 
     * @return  the current element 
     */
    public T getElement() 
    {
        return this.element;
    }

    /**
     * This method gets the next in the linkedlist 
     * @return  the next element in the list
     */
    public Node<T> getNext() 
    {
        return this.nextElement;
    }

    /**
     * This modifier method allows the user to set the next element in the list
     * @param   newNode, the element that will be added next
     */
    public void setNext(Node<T> newNode) 
    {
        this.nextElement = newNode;
    }


}
