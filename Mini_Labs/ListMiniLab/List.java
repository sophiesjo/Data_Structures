import java.util.NoSuchElementException;

/**
 * 
 * A very basic list class.  Elements can only be added at the beginning at
 * the beginning of the list, and can only be removed according to their
 * index.
 * @Author Nathan Sprague and Sophie Sjogren
 * @version April 13, 2021
 *
 */
public class List<T> {
    //Initalize variables used
    private Node<T> first;
    private int size;
    
    /**
     * Create an empty list.
     */
    public List() {
        first = null;
        size = 0;
    }

    /**
     * Adds a new element AT THE BEGINNING of the list. 
     * @param element - The element to add
     */
    public void addElement(T element) 
    {
        Node<T> newElement = new Node<T>(element);      //initialize the current element
        
        //check where to place the element
        if (size == 0)
        {
            first = newElement;
        }
        else if (size > 0)
        {
            newElement.setNext(first);
            first = newElement;
        }
        size++;     //add one to the size
    }
    
    /**
     * Removes and returns the element at the specified index. Throws
     * a noSuchElementException if the index is out of bounds.
     *  
     * @param index - position of the element to remove
     * @return the element that was removed
     * @throws NoSuchElementException
     */
    public T removeElement(int index) throws NoSuchElementException
    {
        Node<T> priorElement = null;        //initialize the previous element as null
        Node<T> nowElement = first;         //initalize the current element
        
        //check if the index is out of bounds 
        if ( index > size || index < 0 )
        {
            throw new NoSuchElementException("The next node is null");
        }
        else
        {
            for (int x = 0; x < index; x++)
            {
                priorElement = nowElement;
                nowElement = priorElement.getNext();
            }
        }
        //check where to set the element
        if (index == 0)
        {
            first = nowElement.getNext();
        }
        else
        {
            priorElement.setNext(nowElement.getNext());
        }
        
        size--;     //minus one from the size
        return nowElement.getElement();
    }
    
    /**
     * Returns the number of elements in the list.
     */
    public int size()
    {
        return size;
    }
}
